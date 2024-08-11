package gs.com.gses.model.elasticsearch;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Document(indexName = "inventory_info")
@Data
public class InventoryInfo {
    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 仓库id
     */
    private Long whid;

    /**
     * 位置id
     */
    private Long locationid;

    /**
     * 托盘号
     */
    private String pallet;

    /**
     * 已分配最小单位数量
     */
    private BigDecimal allocatedsmallunitquantity;

    /**
     * 已分配包装单位数量
     */
    private BigDecimal allocatedpackagequantity;

    /**
     * 质检状态（0待检，1已取样，2合格，-1不合格）
     */
    private Integer qcstatus;

    /**
     * 状态 （0正常，-1禁用）
     */
    private Integer xstatus;

    /**
     * 是否任务锁定
     */
    private Boolean islocked;

    /**
     * 是否封存
     */
    private Boolean issealed;

    /**
     * 是否零托，散货
     */
    private Boolean isscattered;

    /**
     * 是否过期
     */
    private Boolean isexpired;

    /**
     * 备注
     */
    private String comments;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 长
     */
    private BigDecimal length;

    /**
     * 宽
     */
    private BigDecimal width;

    /**
     * 高
     */
    private BigDecimal height;

    /**
     * 预留字段1
     */
    private String str1;

    /**
     * 预留字段2
     */
    private String str2;

    /**
     * 预留字段3
     */
    private String str3;

    /**
     * 预留字段4
     */
    private String str4;

    /**
     * 预留字段5
     */
    private String str5;

    /**
     * 创建人ID
     */
    private Object creatorid;

    /**
     * 创建人名称
     */
    private String creatorname;

    /**
     * 最新修改人ID
     */
    private Object lastmodifierid;

    /**
     * 最新修改人名称
     */
    private String lastmodifiername;

    /**
     * 创建时间戳13位
     */
    private Long creationtime;

    /**
     * 修改时间戳13位
     */
    private Long lastmodificationtime;

    /**
     * 包装单位数量
     */
    private BigDecimal packagequantity;

    /**
     * 最小单位数量
     */
    private BigDecimal smallunitquantity;

    /**
     * 空托层数
     */
    private Integer levelcount;

    /**
     * 输送线编码
     */
    private String conveyorcode;

    /**
     * 理货/备货单号
     */
    private String applyorordercode;

    /**
     * 该库存是用某辆AGVID车号执行的任务
     */
    private Integer orginagvid;

    /**
     * 库存原库位，用户返回原库位使用
     */
    private String orginlocationcode;

    /**
     * 托盘类型,用于设备区分
     */
    private String pallettype;

    /**
     * 体积
     */
    private String volume;
}
