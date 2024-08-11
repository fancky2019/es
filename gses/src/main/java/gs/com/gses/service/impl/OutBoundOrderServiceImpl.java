package gs.com.gses.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import gs.com.gses.elasticsearch.ShipOrderInfoRepository;
import gs.com.gses.model.elasticsearch.DemoProduct;
import gs.com.gses.model.elasticsearch.ShipOrderInfo;
import gs.com.gses.model.entity.*;
import gs.com.gses.model.request.DemoProductRequest;
import gs.com.gses.model.request.ShipOrderInfoRequest;
import gs.com.gses.model.response.PageData;
import gs.com.gses.service.*;
import gs.com.gses.utility.PooledObjectFactoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OutBoundOrderServiceImpl implements OutBoundOrderService {
    // private static final Logger log = LoggerFactory.getLogger(OutBoundOrderServiceImpl.class);
    @Autowired
    private ShipOrderInfoRepository shipOrderInfoRepository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private WmsTaskService wmsTaskService;
    @Autowired
    private WmsTaskArchivedService wmsTaskArchivedService;
    @Autowired
    private ShipPickOrderItemService shipPickOrderItemService;
    @Autowired
    private ShipPickOrderService shipPickOrderService;

    @Autowired
    private ShipOrderItemService shipOrderItemService;
    @Autowired
    private ShipOrderService shipOrderService;

    @Autowired
    private ApplyShipOrderItemService applyShipOrderItemService;
    @Autowired
    private ApplyShipOrderService applyShipOrderService;

    @Autowired
    private WaveShipOrderItemRelationService waveShipOrderItemRelationService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryItemService inventoryItemService;

    @Autowired
    private InventoryItemDetailService inventoryItemDetailService;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private LanewayService lanewayService;

    @Autowired
    private ZoneService zoneService;


    @Override
    public void taskComplete(long wmsTaskId) throws Exception {
        WmsTaskArchived wmsTaskArchived = wmsTaskArchivedService.getById(wmsTaskId);
        WmsTask wmsTask = wmsTaskService.getById(wmsTaskId);
        if (wmsTaskArchived == null && wmsTask == null) {
            throw new Exception("taskId - " + wmsTaskId + " doesn't exist");
        }
        Long shipPickOrderItemId = 0L;
        Long inventoryItemId = 0L;
        Long materialId = 0L;
        if (wmsTask != null) {
            shipPickOrderItemId = wmsTask.getRelationOrderItemId();
            inventoryItemId = wmsTask.getInventoryItemId();
            materialId = wmsTask.getMaterialId();
        } else {
            shipPickOrderItemId = wmsTaskArchived.getRelationOrderItemId();
            inventoryItemId = wmsTaskArchived.getInventoryItemId();
            materialId = wmsTaskArchived.getMaterialId();
        }

        ShipPickOrderItem shipPickOrderItem = shipPickOrderItemService.getById(shipPickOrderItemId);
        ShipPickOrder shipPickOrder = shipPickOrderService.getById(shipPickOrderItem.getShipPickOrderId());
        ShipOrderItem shipOrderItem = shipOrderItemService.getById(shipPickOrderItem.getShipOrderItemId());
        ShipOrder shipOrder = shipOrderService.getById(shipOrderItem.getShipOrderId());
        LambdaQueryWrapper<WaveShipOrderItemRelation> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(WaveShipOrderItemRelation::getShipOrderItemId, shipOrderItem.getId());
        List<WaveShipOrderItemRelation> shipOrderItemRelations = waveShipOrderItemRelationService.list(lambdaQueryWrapper);
        InventoryItem inventoryItem = inventoryItemService.getById(inventoryItemId);
        Inventory inventory = inventoryService.getById(inventoryItem.getInventoryId());
        Material material = materialService.getById(materialId);

        ShipOrderInfo shipOrderInfo = null;
        List<ShipOrderInfo> shipOrderInfoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(shipOrderItemRelations)) {
            List<Long> applyshiporderitemids = shipOrderItemRelations.stream().map(p -> p.getApplyShipOrderItemId()).collect(Collectors.toList());
            List<ApplyShipOrderItem> applyShipOrderItems = applyShipOrderItemService.listByIds(applyshiporderitemids);
            List<Long> applyShipOrderIds = applyShipOrderItems.stream().map(p -> p.getApplyShipOrderId()).collect(Collectors.toList());

            List<ApplyShipOrder> applyShipOrders = applyShipOrderService.listByIds(applyShipOrderIds);
            for (ApplyShipOrderItem applyShipOrderItem : applyShipOrderItems) {
                List<ApplyShipOrder> cuApplyShipOrderList = applyShipOrders.stream().filter(p -> p.getId().equals(applyShipOrderItem.getApplyShipOrderId())).collect(Collectors.toList());
                if (CollectionUtils.isEmpty(cuApplyShipOrderList)) {
                    continue;
                }
                ApplyShipOrder applyShipOrder = cuApplyShipOrderList.get(0);
                shipOrderInfo = new ShipOrderInfo();
                shipOrderInfo.setApplyShipOrderId(applyShipOrder.getId());
                shipOrderInfo.setApplyShipOrderCode(applyShipOrder.getXCode());
                shipOrderInfo.setApplyShipOrderItemId(applyShipOrderItem.getId());
                shipOrderInfo.setApplyShipOrderItemRequiredPkgQuantity(applyShipOrderItem.getRequiredNumber());
                shipOrderInfo.setApplyShipOrderItemAllocatedPkgQuantity(applyShipOrderItem.getAllocatedNumber());

                setShipOrderInfo(shipOrderInfo, material,
                        shipOrder,
                        shipOrderItem,
                        shipPickOrder,
                        shipPickOrderItem,
                        inventory,
                        inventoryItem,
                        wmsTask, wmsTaskArchived);
                shipOrderInfoList.add(shipOrderInfo);
            }
        } else {
            shipOrderInfo = new ShipOrderInfo();
            setShipOrderInfo(shipOrderInfo, material,
                    shipOrder,
                    shipOrderItem,
                    shipPickOrder,
                    shipPickOrderItem,
                    inventory,
                    inventoryItem,
                    wmsTask, wmsTaskArchived);
            shipOrderInfoList.add(shipOrderInfo);
        }
        shipOrderInfoRepository.saveAll(shipOrderInfoList);
    }

    private void setShipOrderInfo(ShipOrderInfo shipOrderInfo, Material material,
                                  ShipOrder shipOrder,
                                  ShipOrderItem shipOrderItem,
                                  ShipPickOrder shipPickOrder,
                                  ShipPickOrderItem shipPickOrderItem,
                                  Inventory inventory,
                                  InventoryItem inventoryItem,
                                  WmsTask wmsTask, WmsTaskArchived wmsTaskArchived) {
        shipOrderInfo.setId(shipOrder.getId());
        shipOrderInfo.setShipOrderCode(shipOrder.getXCode());
        shipOrderInfo.setShipOrderItemAllocatedPkgQuantity(shipOrderItem.getAlloactedPkgQuantity());
        shipOrderInfo.setShipOrderItemRequiredPkgQuantity(shipOrderItem.getRequiredPkgQuantity());
        shipOrderInfo.setShipPickOrderId(shipPickOrder.getId());
        shipOrderInfo.setShipPickOrderItemId(shipPickOrderItem.getId());
        shipOrderInfo.setShipPickOrderItemRequiredPkgQuantity(shipPickOrderItem.getPlanPkgQuantity());
        shipOrderInfo.setShipOrderItemAllocatedPkgQuantity(shipPickOrderItem.getAllocatedPkgQuantity());
        shipOrderInfo.setInventoryId(inventory.getId());
        shipOrderInfo.setInventoryItemId(inventoryItem.getId());
        shipOrderInfo.setMaterialId(material.getId());
        shipOrderInfo.setMaterialName(material.getXName());
        shipOrderInfo.setMaterialCode(material.getXCode());
        shipOrderInfo.setSerialNo("");
        shipOrderInfo.setWorkOrderId(-1L);
        shipOrderInfo.setLocationId(-1L);
        shipOrderInfo.setTaskCompletedTime(LocalDateTime.now());
        if (wmsTask != null) {
            shipOrderInfo.setWmsTaskId(wmsTask.getId());
            shipOrderInfo.setTaskNo(wmsTask.getTaskNo());
            shipOrderInfo.setInventoryItemDetailId(wmsTask.getInventoryItemDetailId());
            shipOrderInfo.setPallet(wmsTask.getPalletCode());
            shipOrderInfo.setMovedPkgQuantity(wmsTask.getMovedPkgQuantity());
            shipOrderInfo.setMaterialId(wmsTask.getMaterialId());
        } else {
            shipOrderInfo.setWmsTaskId(wmsTaskArchived.getId());
            shipOrderInfo.setTaskNo(wmsTaskArchived.getTaskNo());
            shipOrderInfo.setInventoryItemDetailId(wmsTaskArchived.getInventoryItemDetailId());
            shipOrderInfo.setPallet(wmsTaskArchived.getPalletCode());
            shipOrderInfo.setMovedPkgQuantity(wmsTaskArchived.getMovedPkgQuantity());
            shipOrderInfo.setMaterialId(wmsTaskArchived.getMaterialId());
        }

    }


    @Override
    public PageData<ShipOrderInfo> search(ShipOrderInfoRequest request) {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (request.getId() != null && request.getId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("id", request.getId()));
        }
        if (request.getApplyShipOrderId() != null && request.getApplyShipOrderId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("applyShipOrderId", request.getApplyShipOrderId()));
        }

        if (StringUtils.isNotEmpty(request.getApplyShipOrderCode())) {
            //guid 设置keyword  不成功 ES8
//            boolQueryBuilder.must(QueryBuilders.termQuery("guid.keyword", request.getGuid()));
            //es7
            boolQueryBuilder.must(QueryBuilders.termQuery("applyShipOrderCode", request.getApplyShipOrderCode()));
        }

        if (request.getApplyShipOrderItemId() != null && request.getApplyShipOrderItemId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("applyShipOrderItemId", request.getApplyShipOrderItemId()));
        }


        if (StringUtils.isNotEmpty(request.getShipOrderCode())) {

            boolQueryBuilder.must(QueryBuilders.termQuery("shipOrderCode", request.getShipOrderCode()));
        }

        if (request.getShipOrderItemId() != null && request.getShipOrderItemId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("shipOrderItemId", request.getShipOrderItemId()));
        }
        if (request.getShipPickOrderId() != null && request.getShipPickOrderId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("shipPickOrderId", request.getShipPickOrderId()));
        }
        if (request.getShipPickOrderItemId() != null && request.getShipPickOrderItemId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("shipPickOrderItemId", request.getShipPickOrderItemId()));
        }
        if (request.getWmsTaskId() != null && request.getWmsTaskId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("wmsTaskId", request.getWmsTaskId()));
        }
        if (StringUtils.isNotEmpty(request.getTaskNo())) {

            boolQueryBuilder.must(QueryBuilders.termQuery("taskNo", request.getTaskNo()));
        }
        if (request.getInventoryId() != null && request.getInventoryId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("inventoryId", request.getInventoryId()));
        }
        if (request.getInventoryItemId() != null && request.getInventoryItemId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("inventoryItemId", request.getInventoryItemId()));
        }
        if (request.getInventoryItemDetailId() != null && request.getInventoryItemDetailId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("inventoryItemDetailId", request.getInventoryItemDetailId()));
        }
        if (StringUtils.isNotEmpty(request.getPallet())) {

            boolQueryBuilder.must(QueryBuilders.termQuery("pallet", request.getPallet()));
        }
        if (request.getMaterialId() != null && request.getMaterialId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("materialId", request.getMaterialId()));
        }
        if (StringUtils.isNotEmpty(request.getMaterialName())) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("materialName", request.getMaterialName()));
        }
        if (StringUtils.isNotEmpty(request.getMaterialCode())) {

            boolQueryBuilder.must(QueryBuilders.termQuery("materialCode", request.getMaterialCode()));
        }
        if (StringUtils.isNotEmpty(request.getSerialNo())) {

            boolQueryBuilder.must(QueryBuilders.termQuery("serialNo", request.getSerialNo()));
        }
        if (request.getWorkOrderId() != null && request.getWorkOrderId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("workOrderId", request.getWorkOrderId()));
        }
        if (request.getLocationId() != null && request.getLocationId() > 0) {
            boolQueryBuilder.must(QueryBuilders.termQuery("locationId", request.getLocationId()));
        }


        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                //查询条件:es支持分词查询，最小是一个词，要精确匹配分词
                //在指定字段中查找值
//                .withQuery(QueryBuilders.queryStringQuery("合肥").field("product_name").field("produce_address"))
                // .withQuery(QueryBuilders.multiMatchQuery("安徽合肥", "product_name", "produce_address"))

                .withQuery(boolQueryBuilder)//必须要加keyword，否则查不出来
                //SEARCH_AFTER 不用指定 from size
//                .withQuery(QueryBuilders.rangeQuery("price").from("5").to("9"))//多个条件and 的关系
                //分页：page 从0开始
                .withPageable(PageRequest.of(request.getPageIndex(), request.getPageSize()))
                //排序
                .withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC))
                //高亮字段显示
//                .withHighlightFields(new HighlightBuilder.Field("product_name"))
                .withTrackTotalHits(true)//解除最大1W条限制
                .build();
//        nativeSearchQuery.setTrackTotalHitsUpTo(10000000);
        SearchHits<ShipOrderInfo> search = elasticsearchRestTemplate.search(nativeSearchQuery, ShipOrderInfo.class);
        List<ShipOrderInfo> shipOrderInfoList = search.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());

        long count = search.getTotalHits();
        PageData<ShipOrderInfo> pageData = new PageData<>();
        pageData.setCount(count);
        pageData.setData(shipOrderInfoList);
//        elasticsearchRestTemplate.bulkUpdate();
//        elasticsearchRestTemplate.bulkIndex();
//        elasticsearchRestTemplate.delete()
//        elasticsearchRestTemplate.save()
        return pageData;
    }

    @Override
    public void addBatch() throws Exception {
        String[] names = {"上海市", "徐汇区", "漕河泾", "闵行区", "中国", "鞋子", "帽子", "太阳", "月亮",
                "初中", "高中", "小学", "大学", "佘山", "浦东区", "陆家嘴", "张江", "北京市", "黄山",
                "复旦", "同济", "海洋", "石油", "乌龟", "王八", "苹果树", "梨树", "电影", "香蕉",
                "小猫", "狼狗", "鸡肉", "牛肉", "金枪鱼",
        };
        int length = names.length;
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(1010);
        //默认8个
        config.setMaxTotal(1050);
        GenericObjectPool<ShipOrderInfo> objectPool = new GenericObjectPool<>(new PooledObjectFactoryImpl<>(ShipOrderInfo.class), config);
        ShipOrderInfo shipOrderInfo = null;
        //磁盘空间不足，只能写500W
        for (long j = 7731; j < 10000; j++) {
            List<ShipOrderInfo> shipOrderInfoList = new ArrayList<>();
            for (long m = 0; m < 1000; m++) {
                long i = j * 1000 + m;
                long id = i + 1;
                BigDecimal quantity = BigDecimal.valueOf(i);
//                shipOrderInfo = objectPool.borrowObject();
                shipOrderInfo = new ShipOrderInfo();
                shipOrderInfo.setApplyShipOrderId(id);
                shipOrderInfo.setApplyShipOrderCode("ApplyShipOrderCode" + i);
                shipOrderInfo.setApplyShipOrderItemId(id);
                shipOrderInfo.setApplyShipOrderItemRequiredPkgQuantity(quantity);
                shipOrderInfo.setApplyShipOrderItemAllocatedPkgQuantity(quantity);

                shipOrderInfo.setId(id);
                shipOrderInfo.setShipOrderCode("ShipOrderCode" + i);
                shipOrderInfo.setShipOrderItemAllocatedPkgQuantity(quantity);
                shipOrderInfo.setShipOrderItemRequiredPkgQuantity(quantity);
                shipOrderInfo.setShipPickOrderId(id);
                shipOrderInfo.setShipPickOrderItemId(id);
                shipOrderInfo.setShipPickOrderItemRequiredPkgQuantity(quantity);
                shipOrderInfo.setShipOrderItemAllocatedPkgQuantity(quantity);
                shipOrderInfo.setInventoryId(id);
                shipOrderInfo.setInventoryItemId(id);
                shipOrderInfo.setMaterialId(id);
                int index = (int) i % length;
                shipOrderInfo.setMaterialName(names[index]);
                shipOrderInfo.setMaterialCode("material" + i);
                shipOrderInfo.setSerialNo("SerialNo" + i);
                shipOrderInfo.setWorkOrderId(id);
                shipOrderInfo.setLocationId(id);
                shipOrderInfo.setTaskCompletedTime(LocalDateTime.now());

                shipOrderInfo.setWmsTaskId(id);
                shipOrderInfo.setTaskNo("WmsTask" + i);
                shipOrderInfo.setInventoryItemDetailId(id);
                shipOrderInfo.setPallet("Palletcode" + i);
                shipOrderInfo.setMovedPkgQuantity(quantity);
                shipOrderInfo.setMaterialId(id);

                shipOrderInfo.setMaterialProperty1("MaterialProperty1_" + i);
                shipOrderInfo.setMaterialProperty2("MaterialProperty2_" + i);
                shipOrderInfo.setMaterialProperty3("MaterialProperty3_" + i);
                shipOrderInfo.setMaterialProperty4("MaterialProperty4_" + i);
                shipOrderInfo.setMaterialProperty5("MaterialProperty5_" + i);
                shipOrderInfo.setMaterialProperty6("MaterialProperty6_" + i);
                shipOrderInfo.setMaterialProperty7("MaterialProperty7_" + i);
                shipOrderInfo.setMaterialProperty8("MaterialProperty8_" + i);
                shipOrderInfo.setMaterialProperty9("MaterialProperty9_" + i);
                shipOrderInfo.setMaterialProperty10("MaterialProperty10_" + i);
                shipOrderInfo.setMaterialProperty11("MaterialProperty11_" + i);
                shipOrderInfo.setMaterialProperty12("MaterialProperty12_" + i);
                shipOrderInfo.setMaterialProperty13("MaterialProperty13_" + i);
                shipOrderInfo.setMaterialProperty14("MaterialProperty14_" + i);
                shipOrderInfo.setMaterialProperty15("MaterialProperty15_" + i);
                shipOrderInfo.setMaterialProperty16("MaterialProperty16_" + i);
                shipOrderInfo.setMaterialProperty17("MaterialProperty17_" + i);
                shipOrderInfo.setMaterialProperty18("MaterialProperty18_" + i);
                shipOrderInfo.setMaterialProperty19("MaterialProperty19_" + i);
                shipOrderInfo.setMaterialProperty20("MaterialProperty20_" + i);
                shipOrderInfo.setMaterialProperty21("MaterialProperty21_" + i);
                shipOrderInfo.setMaterialProperty22("MaterialProperty22_" + i);
                shipOrderInfo.setMaterialProperty23("MaterialProperty23_" + i);
                shipOrderInfo.setMaterialProperty24("MaterialProperty24_" + i);
                shipOrderInfo.setMaterialProperty25("MaterialProperty25_" + i);
                shipOrderInfo.setMaterialProperty26("MaterialProperty26_" + i);
                shipOrderInfo.setMaterialProperty27("MaterialProperty27_" + i);
                shipOrderInfo.setMaterialProperty28("MaterialProperty28_" + i);
                shipOrderInfo.setMaterialProperty29("MaterialProperty29_" + i);
                shipOrderInfo.setMaterialProperty30("MaterialProperty30_" + i);
                shipOrderInfo.setMaterialProperty31("MaterialProperty31_" + i);
                shipOrderInfo.setMaterialProperty32("MaterialProperty32_" + i);
                shipOrderInfo.setMaterialProperty33("MaterialProperty33_" + i);
                shipOrderInfo.setMaterialProperty34("MaterialProperty34_" + i);
                shipOrderInfo.setMaterialProperty35("MaterialProperty35_" + i);
                shipOrderInfo.setMaterialProperty36("MaterialProperty36_" + i);
                shipOrderInfo.setMaterialProperty37("MaterialProperty37_" + i);
                shipOrderInfo.setMaterialProperty38("MaterialProperty38_" + i);
                shipOrderInfo.setMaterialProperty39("MaterialProperty39_" + i);
                shipOrderInfo.setMaterialProperty40("MaterialProperty40_" + i);
                shipOrderInfo.setMaterialProperty41("MaterialProperty41_" + i);
                shipOrderInfo.setMaterialProperty42("MaterialProperty42_" + i);
                shipOrderInfo.setMaterialProperty43("MaterialProperty43_" + i);
                shipOrderInfo.setMaterialProperty44("MaterialProperty44_" + i);
                shipOrderInfo.setMaterialProperty45("MaterialProperty45_" + i);
                shipOrderInfo.setMaterialProperty46("MaterialProperty46_" + i);
                shipOrderInfo.setMaterialProperty47("MaterialProperty47_" + i);
                shipOrderInfo.setMaterialProperty48("MaterialProperty48_" + i);
                shipOrderInfo.setMaterialProperty49("MaterialProperty49_" + i);
                shipOrderInfo.setMaterialProperty50("MaterialProperty50_" + i);

                shipOrderInfo.setShipOrderItemProperty1("ShipOrderItemProperty1_" + i);
                shipOrderInfo.setShipOrderItemProperty2("ShipOrderItemProperty2_" + i);
                shipOrderInfo.setShipOrderItemProperty3("ShipOrderItemProperty3_" + i);
                shipOrderInfo.setShipOrderItemProperty4("ShipOrderItemProperty4_" + i);
                shipOrderInfo.setShipOrderItemProperty5("ShipOrderItemProperty5_" + i);
                shipOrderInfo.setShipOrderItemProperty6("ShipOrderItemProperty6_" + i);
                shipOrderInfo.setShipOrderItemProperty7("ShipOrderItemProperty7_" + i);
                shipOrderInfo.setShipOrderItemProperty8("ShipOrderItemProperty8_" + i);
                shipOrderInfo.setShipOrderItemProperty9("ShipOrderItemProperty9_" + i);
                shipOrderInfo.setShipOrderItemProperty10("ShipOrderItemProperty10_" + i);
                shipOrderInfo.setShipOrderItemProperty11("ShipOrderItemProperty11_" + i);
                shipOrderInfo.setShipOrderItemProperty12("ShipOrderItemProperty12_" + i);
                shipOrderInfo.setShipOrderItemProperty13("ShipOrderItemProperty13_" + i);
                shipOrderInfo.setShipOrderItemProperty14("ShipOrderItemProperty14_" + i);
                shipOrderInfo.setShipOrderItemProperty15("ShipOrderItemProperty15_" + i);
                shipOrderInfo.setShipOrderItemProperty16("ShipOrderItemProperty16_" + i);
                shipOrderInfo.setShipOrderItemProperty17("ShipOrderItemProperty17_" + i);
                shipOrderInfo.setShipOrderItemProperty18("ShipOrderItemProperty18_" + i);
                shipOrderInfo.setShipOrderItemProperty19("ShipOrderItemProperty19_" + i);
                shipOrderInfo.setShipOrderItemProperty20("ShipOrderItemProperty20_" + i);

                shipOrderInfoList.add(shipOrderInfo);
            }

            //仓储慢,几乎比模板慢了一半
//            shipOrderInfoRepository.saveAll(shipOrderInfoList);
            elasticsearchRestTemplate.save(shipOrderInfoList);
//            for (ShipOrderInfo obj : shipOrderInfoList) {
//                objectPool.returnObject(obj);
//            }
        }
//        objectPool.clear();
    }

    @Override
    public boolean deleteShipOrderInfo() {
        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(ShipOrderInfo.class);
        return indexOperations.delete();
    }

    @Override
    public void initFromDb() {
        long count = this.inventoryItemDetailService.count();
        int step = 1000;
        long times = count / step;
        long left = count / step;
        if (left > 0) {
            times++;
        }
        //current :pageIndex  ,size:pageSize
        Page<InventoryItemDetail> page = new Page<>(1, step);
        long pageIndex = 0L;
        while (times > 0) {
            times--;
            page.setCurrent(++pageIndex);
            IPage<InventoryItemDetail> inventoryItemDetailPage = this.inventoryItemDetailService.page(page);
            List<InventoryItemDetail> inventoryItemDetailList = inventoryItemDetailPage.getRecords();
            List<Long> inventoryItemIdList = inventoryItemDetailList.stream().map(p -> p.getInventoryItemId()).distinct().collect(Collectors.toList());
            List<InventoryItem> inventoryItemList =  this.inventoryItemService.listByIds(inventoryItemIdList);
            List<Long> inventoryIdList = inventoryItemList.stream().map(p -> p.getInventoryId()).distinct().collect(Collectors.toList());
            List<Inventory> inventorylList =  this.inventoryService.listByIds(inventoryIdList);
            //material
            List<Long>  materialIdList= inventoryItemDetailList.stream().map(p -> p.getMaterialId()).distinct().collect(Collectors.toList());
            List<Material> materialList =     this.materialService.listByIds(materialIdList);

            List<Long>  locationIdList= inventorylList.stream().map(p -> p.getLocationId()).distinct().collect(Collectors.toList());
            List<Location> locationList =     this.locationService.listByIds(locationIdList);

            List<Long>  lanewayIdList= locationList.stream().map(p -> p.getLanewayId()).distinct().collect(Collectors.toList());
            List<Laneway> lanewayList =     this.lanewayService.listByIds(locationIdList);

            List<Long>  zoneIdList= lanewayList.stream().map(p -> p.getZoneId()).distinct().collect(Collectors.toList());
            List<Zone> zoneList =     this.zoneService.listByIds(locationIdList);


        }
    }

    /**
     * 创建索引及映射
     * @return
     */
    public Boolean createIndexAndMapping() {
        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(ShipOrderInfo.class);
        //创建索引
        boolean result = indexOperations.create();
        if (result) {
            //生成映射
            Document mapping = indexOperations.createMapping();
            //推送映射
            return indexOperations.putMapping(mapping);
        } else {
            return result;
        }
    }


}
