package gs.com.gses.elasticsearch;

import gs.com.gses.model.elasticsearch.InventoryInfo;
import gs.com.gses.model.elasticsearch.ShipOrderInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryInfoRepository extends ElasticsearchRepository<InventoryInfo, Long> {
    //spring data repository 可以添加自定义方法。spring会自动实现。规则参见doc文件夹下repository
}
