package gs.com.gses.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName ShipPickOrderArchieved
 */
@TableName(value ="ShipPickOrderArchieved")
@Data
public class ShipPickOrderArchieved implements Serializable {
    /**
     * 
     */
    @TableId(value = "Id")
    private Long id;

    /**
     * 关联的出库单主表id
     */
    @TableField(value = "ShipOrderId")
    private Long shipOrderId;

    /**
     * 创建人ID
     */
    @TableField(value = "CreatorId")
    private Object creatorId;

    /**
     * 创建人名称
     */
    @TableField(value = "CreatorName")
    private String creatorName;

    /**
     * 最新修改人ID
     */
    @TableField(value = "LastModifierId")
    private Object lastModifierId;

    /**
     * 最新修改人名称
     */
    @TableField(value = "LastModifierName")
    private String lastModifierName;

    /**
     * 创建时间戳13位
     */
    @TableField(value = "CreationTime")
    private Long creationTime;

    /**
     * 修改时间戳13位
     */
    @TableField(value = "LastModificationTime")
    private Long lastModificationTime;

    /**
     * 仓库id
     */
    @TableField(value = "WarehouseId")
    private Long warehouseId;

    /**
     * 拣货单号
     */
    @TableField(value = "ShipPickOrderCode")
    private String shipPickOrderCode;

    /**
     * 单据类型id
     */
    @TableField(value = "BillTypeId")
    private Long billTypeId;

    /**
     * 状态 （1open新建，2部分分配，3整单分配，4执行中，5已完成，-1作废）
     */
    @TableField(value = "Status")
    private Integer status;

    /**
     * 计划上架数量
     */
    @TableField(value = "PlanPkgQuantity")
    private BigDecimal planPkgQuantity;

    /**
     * 分配数量
     */
    @TableField(value = "AllocatedPkgQuantity")
    private BigDecimal allocatedPkgQuantity;

    /**
     * 已下架数量
     */
    @TableField(value = "MovedPkgQuantity")
    private BigDecimal movedPkgQuantity;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}