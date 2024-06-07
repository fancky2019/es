package gs.com.gses.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName WaveShipOrderItemRelation
 */
@TableName(value ="WaveShipOrderItemRelation")
@Data
public class WaveShipOrderItemRelation implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 关联的出库单明细表id
     */
    private Long shiporderitemid;

    /**
     * 关联的出库申请单明细表id
     */
    private Long applyshiporderitemid;

    /**
     * 波次需求数量
     */
    private BigDecimal requirednumber;

    /**
     * 已拣货数量
     */
    private BigDecimal pickednumber;

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
        WaveShipOrderItemRelation other = (WaveShipOrderItemRelation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShiporderitemid() == null ? other.getShiporderitemid() == null : this.getShiporderitemid().equals(other.getShiporderitemid()))
            && (this.getApplyshiporderitemid() == null ? other.getApplyshiporderitemid() == null : this.getApplyshiporderitemid().equals(other.getApplyshiporderitemid()))
            && (this.getRequirednumber() == null ? other.getRequirednumber() == null : this.getRequirednumber().equals(other.getRequirednumber()))
            && (this.getPickednumber() == null ? other.getPickednumber() == null : this.getPickednumber().equals(other.getPickednumber()))
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
        result = prime * result + ((getShiporderitemid() == null) ? 0 : getShiporderitemid().hashCode());
        result = prime * result + ((getApplyshiporderitemid() == null) ? 0 : getApplyshiporderitemid().hashCode());
        result = prime * result + ((getRequirednumber() == null) ? 0 : getRequirednumber().hashCode());
        result = prime * result + ((getPickednumber() == null) ? 0 : getPickednumber().hashCode());
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
        sb.append(", shiporderitemid=").append(shiporderitemid);
        sb.append(", applyshiporderitemid=").append(applyshiporderitemid);
        sb.append(", requirednumber=").append(requirednumber);
        sb.append(", pickednumber=").append(pickednumber);
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