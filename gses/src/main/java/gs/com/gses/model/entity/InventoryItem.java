package gs.com.gses.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName InventoryItem
 */
@TableName(value ="InventoryItem")
@Data
public class InventoryItem implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 库存主表id
     */
    private Long inventoryid;

    /**
     * 物料id
     */
    private Long materialid;

    /**
     * 包装单位id
     */
    private Long packageunitid;

    /**
     * 最小单位数量
     */
    private BigDecimal smallunitquantity;

    /**
     * 包装单位数量
     */
    private BigDecimal packagequantity;

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
     * 过期时间时间戳
     */
    private Long expiredtime;

    /**
     * 备注
     */
    private String comments;

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
     * 组织（客户）
     */
    private Long organiztionid;

    /**
     * 组织（供应商）
     */
    private Long organiztionsupplierid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}