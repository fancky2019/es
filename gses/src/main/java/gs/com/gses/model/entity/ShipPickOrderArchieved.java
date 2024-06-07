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
    @TableId
    private Long id;

    /**
     * 关联的出库单主表id
     */
    private Long shiporderid;

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
     * 仓库id
     */
    private Long warehouseid;

    /**
     * 拣货单号
     */
    private String shippickordercode;

    /**
     * 单据类型id
     */
    private Long billtypeid;

    /**
     * 状态 （1open新建，2部分分配，3整单分配，4执行中，5已完成，-1作废）
     */
    private Integer status;

    /**
     * 计划上架数量
     */
    private BigDecimal planpkgquantity;

    /**
     * 分配数量
     */
    private BigDecimal allocatedpkgquantity;

    /**
     * 已下架数量
     */
    private BigDecimal movedpkgquantity;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ShipPickOrderArchieved other = (ShipPickOrderArchieved) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShiporderid() == null ? other.getShiporderid() == null : this.getShiporderid().equals(other.getShiporderid()))
            && (this.getCreatorid() == null ? other.getCreatorid() == null : this.getCreatorid().equals(other.getCreatorid()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getLastmodifierid() == null ? other.getLastmodifierid() == null : this.getLastmodifierid().equals(other.getLastmodifierid()))
            && (this.getLastmodifiername() == null ? other.getLastmodifiername() == null : this.getLastmodifiername().equals(other.getLastmodifiername()))
            && (this.getCreationtime() == null ? other.getCreationtime() == null : this.getCreationtime().equals(other.getCreationtime()))
            && (this.getLastmodificationtime() == null ? other.getLastmodificationtime() == null : this.getLastmodificationtime().equals(other.getLastmodificationtime()))
            && (this.getWarehouseid() == null ? other.getWarehouseid() == null : this.getWarehouseid().equals(other.getWarehouseid()))
            && (this.getShippickordercode() == null ? other.getShippickordercode() == null : this.getShippickordercode().equals(other.getShippickordercode()))
            && (this.getBilltypeid() == null ? other.getBilltypeid() == null : this.getBilltypeid().equals(other.getBilltypeid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPlanpkgquantity() == null ? other.getPlanpkgquantity() == null : this.getPlanpkgquantity().equals(other.getPlanpkgquantity()))
            && (this.getAllocatedpkgquantity() == null ? other.getAllocatedpkgquantity() == null : this.getAllocatedpkgquantity().equals(other.getAllocatedpkgquantity()))
            && (this.getMovedpkgquantity() == null ? other.getMovedpkgquantity() == null : this.getMovedpkgquantity().equals(other.getMovedpkgquantity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShiporderid() == null) ? 0 : getShiporderid().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getLastmodifierid() == null) ? 0 : getLastmodifierid().hashCode());
        result = prime * result + ((getLastmodifiername() == null) ? 0 : getLastmodifiername().hashCode());
        result = prime * result + ((getCreationtime() == null) ? 0 : getCreationtime().hashCode());
        result = prime * result + ((getLastmodificationtime() == null) ? 0 : getLastmodificationtime().hashCode());
        result = prime * result + ((getWarehouseid() == null) ? 0 : getWarehouseid().hashCode());
        result = prime * result + ((getShippickordercode() == null) ? 0 : getShippickordercode().hashCode());
        result = prime * result + ((getBilltypeid() == null) ? 0 : getBilltypeid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPlanpkgquantity() == null) ? 0 : getPlanpkgquantity().hashCode());
        result = prime * result + ((getAllocatedpkgquantity() == null) ? 0 : getAllocatedpkgquantity().hashCode());
        result = prime * result + ((getMovedpkgquantity() == null) ? 0 : getMovedpkgquantity().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shiporderid=").append(shiporderid);
        sb.append(", creatorid=").append(creatorid);
        sb.append(", creatorname=").append(creatorname);
        sb.append(", lastmodifierid=").append(lastmodifierid);
        sb.append(", lastmodifiername=").append(lastmodifiername);
        sb.append(", creationtime=").append(creationtime);
        sb.append(", lastmodificationtime=").append(lastmodificationtime);
        sb.append(", warehouseid=").append(warehouseid);
        sb.append(", shippickordercode=").append(shippickordercode);
        sb.append(", billtypeid=").append(billtypeid);
        sb.append(", status=").append(status);
        sb.append(", planpkgquantity=").append(planpkgquantity);
        sb.append(", allocatedpkgquantity=").append(allocatedpkgquantity);
        sb.append(", movedpkgquantity=").append(movedpkgquantity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}