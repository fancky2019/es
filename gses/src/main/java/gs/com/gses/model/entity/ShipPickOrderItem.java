package gs.com.gses.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName ShipPickOrderItem
 */
@TableName(value ="ShipPickOrderItem")
@Data
public class ShipPickOrderItem implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 拣货主表单id
     */
    private Long shippickorderid;

    /**
     * 发货单明细表id（标识这个拣货明细对应的发货单明细行项）
     */
    private Long shiporderitemid;

    /**
     * 计划拣货数量
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

    /**
     * 起点位置ID
     */
    private Long fromlocid;

    /**
     * 起点位置编号
     */
    private String fromloccode;

    /**
     * 终点位置ID
     */
    private Long tolocid;

    /**
     * 终点位置编号
     */
    private String toloccode;

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
        ShipPickOrderItem other = (ShipPickOrderItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShippickorderid() == null ? other.getShippickorderid() == null : this.getShippickorderid().equals(other.getShippickorderid()))
            && (this.getShiporderitemid() == null ? other.getShiporderitemid() == null : this.getShiporderitemid().equals(other.getShiporderitemid()))
            && (this.getPlanpkgquantity() == null ? other.getPlanpkgquantity() == null : this.getPlanpkgquantity().equals(other.getPlanpkgquantity()))
            && (this.getAllocatedpkgquantity() == null ? other.getAllocatedpkgquantity() == null : this.getAllocatedpkgquantity().equals(other.getAllocatedpkgquantity()))
            && (this.getMovedpkgquantity() == null ? other.getMovedpkgquantity() == null : this.getMovedpkgquantity().equals(other.getMovedpkgquantity()))
            && (this.getFromlocid() == null ? other.getFromlocid() == null : this.getFromlocid().equals(other.getFromlocid()))
            && (this.getFromloccode() == null ? other.getFromloccode() == null : this.getFromloccode().equals(other.getFromloccode()))
            && (this.getTolocid() == null ? other.getTolocid() == null : this.getTolocid().equals(other.getTolocid()))
            && (this.getToloccode() == null ? other.getToloccode() == null : this.getToloccode().equals(other.getToloccode()))
            && (this.getCreatorid() == null ? other.getCreatorid() == null : this.getCreatorid().equals(other.getCreatorid()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getLastmodifierid() == null ? other.getLastmodifierid() == null : this.getLastmodifierid().equals(other.getLastmodifierid()))
            && (this.getLastmodifiername() == null ? other.getLastmodifiername() == null : this.getLastmodifiername().equals(other.getLastmodifiername()))
            && (this.getCreationtime() == null ? other.getCreationtime() == null : this.getCreationtime().equals(other.getCreationtime()))
            && (this.getLastmodificationtime() == null ? other.getLastmodificationtime() == null : this.getLastmodificationtime().equals(other.getLastmodificationtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShippickorderid() == null) ? 0 : getShippickorderid().hashCode());
        result = prime * result + ((getShiporderitemid() == null) ? 0 : getShiporderitemid().hashCode());
        result = prime * result + ((getPlanpkgquantity() == null) ? 0 : getPlanpkgquantity().hashCode());
        result = prime * result + ((getAllocatedpkgquantity() == null) ? 0 : getAllocatedpkgquantity().hashCode());
        result = prime * result + ((getMovedpkgquantity() == null) ? 0 : getMovedpkgquantity().hashCode());
        result = prime * result + ((getFromlocid() == null) ? 0 : getFromlocid().hashCode());
        result = prime * result + ((getFromloccode() == null) ? 0 : getFromloccode().hashCode());
        result = prime * result + ((getTolocid() == null) ? 0 : getTolocid().hashCode());
        result = prime * result + ((getToloccode() == null) ? 0 : getToloccode().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getLastmodifierid() == null) ? 0 : getLastmodifierid().hashCode());
        result = prime * result + ((getLastmodifiername() == null) ? 0 : getLastmodifiername().hashCode());
        result = prime * result + ((getCreationtime() == null) ? 0 : getCreationtime().hashCode());
        result = prime * result + ((getLastmodificationtime() == null) ? 0 : getLastmodificationtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shippickorderid=").append(shippickorderid);
        sb.append(", shiporderitemid=").append(shiporderitemid);
        sb.append(", planpkgquantity=").append(planpkgquantity);
        sb.append(", allocatedpkgquantity=").append(allocatedpkgquantity);
        sb.append(", movedpkgquantity=").append(movedpkgquantity);
        sb.append(", fromlocid=").append(fromlocid);
        sb.append(", fromloccode=").append(fromloccode);
        sb.append(", tolocid=").append(tolocid);
        sb.append(", toloccode=").append(toloccode);
        sb.append(", creatorid=").append(creatorid);
        sb.append(", creatorname=").append(creatorname);
        sb.append(", lastmodifierid=").append(lastmodifierid);
        sb.append(", lastmodifiername=").append(lastmodifiername);
        sb.append(", creationtime=").append(creationtime);
        sb.append(", lastmodificationtime=").append(lastmodificationtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}