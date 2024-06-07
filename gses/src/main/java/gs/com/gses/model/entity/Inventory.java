package gs.com.gses.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName Inventory
 */
@TableName(value ="Inventory")
@Data
public class Inventory implements Serializable {
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
        Inventory other = (Inventory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWhid() == null ? other.getWhid() == null : this.getWhid().equals(other.getWhid()))
            && (this.getLocationid() == null ? other.getLocationid() == null : this.getLocationid().equals(other.getLocationid()))
            && (this.getPallet() == null ? other.getPallet() == null : this.getPallet().equals(other.getPallet()))
            && (this.getAllocatedsmallunitquantity() == null ? other.getAllocatedsmallunitquantity() == null : this.getAllocatedsmallunitquantity().equals(other.getAllocatedsmallunitquantity()))
            && (this.getAllocatedpackagequantity() == null ? other.getAllocatedpackagequantity() == null : this.getAllocatedpackagequantity().equals(other.getAllocatedpackagequantity()))
            && (this.getQcstatus() == null ? other.getQcstatus() == null : this.getQcstatus().equals(other.getQcstatus()))
            && (this.getXstatus() == null ? other.getXstatus() == null : this.getXstatus().equals(other.getXstatus()))
            && (this.getIslocked() == null ? other.getIslocked() == null : this.getIslocked().equals(other.getIslocked()))
            && (this.getIssealed() == null ? other.getIssealed() == null : this.getIssealed().equals(other.getIssealed()))
            && (this.getIsscattered() == null ? other.getIsscattered() == null : this.getIsscattered().equals(other.getIsscattered()))
            && (this.getIsexpired() == null ? other.getIsexpired() == null : this.getIsexpired().equals(other.getIsexpired()))
            && (this.getComments() == null ? other.getComments() == null : this.getComments().equals(other.getComments()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getLength() == null ? other.getLength() == null : this.getLength().equals(other.getLength()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getStr1() == null ? other.getStr1() == null : this.getStr1().equals(other.getStr1()))
            && (this.getStr2() == null ? other.getStr2() == null : this.getStr2().equals(other.getStr2()))
            && (this.getStr3() == null ? other.getStr3() == null : this.getStr3().equals(other.getStr3()))
            && (this.getStr4() == null ? other.getStr4() == null : this.getStr4().equals(other.getStr4()))
            && (this.getStr5() == null ? other.getStr5() == null : this.getStr5().equals(other.getStr5()))
            && (this.getCreatorid() == null ? other.getCreatorid() == null : this.getCreatorid().equals(other.getCreatorid()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getLastmodifierid() == null ? other.getLastmodifierid() == null : this.getLastmodifierid().equals(other.getLastmodifierid()))
            && (this.getLastmodifiername() == null ? other.getLastmodifiername() == null : this.getLastmodifiername().equals(other.getLastmodifiername()))
            && (this.getCreationtime() == null ? other.getCreationtime() == null : this.getCreationtime().equals(other.getCreationtime()))
            && (this.getLastmodificationtime() == null ? other.getLastmodificationtime() == null : this.getLastmodificationtime().equals(other.getLastmodificationtime()))
            && (this.getPackagequantity() == null ? other.getPackagequantity() == null : this.getPackagequantity().equals(other.getPackagequantity()))
            && (this.getSmallunitquantity() == null ? other.getSmallunitquantity() == null : this.getSmallunitquantity().equals(other.getSmallunitquantity()))
            && (this.getLevelcount() == null ? other.getLevelcount() == null : this.getLevelcount().equals(other.getLevelcount()))
            && (this.getConveyorcode() == null ? other.getConveyorcode() == null : this.getConveyorcode().equals(other.getConveyorcode()))
            && (this.getApplyorordercode() == null ? other.getApplyorordercode() == null : this.getApplyorordercode().equals(other.getApplyorordercode()))
            && (this.getOrginagvid() == null ? other.getOrginagvid() == null : this.getOrginagvid().equals(other.getOrginagvid()))
            && (this.getOrginlocationcode() == null ? other.getOrginlocationcode() == null : this.getOrginlocationcode().equals(other.getOrginlocationcode()))
            && (this.getPallettype() == null ? other.getPallettype() == null : this.getPallettype().equals(other.getPallettype()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWhid() == null) ? 0 : getWhid().hashCode());
        result = prime * result + ((getLocationid() == null) ? 0 : getLocationid().hashCode());
        result = prime * result + ((getPallet() == null) ? 0 : getPallet().hashCode());
        result = prime * result + ((getAllocatedsmallunitquantity() == null) ? 0 : getAllocatedsmallunitquantity().hashCode());
        result = prime * result + ((getAllocatedpackagequantity() == null) ? 0 : getAllocatedpackagequantity().hashCode());
        result = prime * result + ((getQcstatus() == null) ? 0 : getQcstatus().hashCode());
        result = prime * result + ((getXstatus() == null) ? 0 : getXstatus().hashCode());
        result = prime * result + ((getIslocked() == null) ? 0 : getIslocked().hashCode());
        result = prime * result + ((getIssealed() == null) ? 0 : getIssealed().hashCode());
        result = prime * result + ((getIsscattered() == null) ? 0 : getIsscattered().hashCode());
        result = prime * result + ((getIsexpired() == null) ? 0 : getIsexpired().hashCode());
        result = prime * result + ((getComments() == null) ? 0 : getComments().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getLength() == null) ? 0 : getLength().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getStr1() == null) ? 0 : getStr1().hashCode());
        result = prime * result + ((getStr2() == null) ? 0 : getStr2().hashCode());
        result = prime * result + ((getStr3() == null) ? 0 : getStr3().hashCode());
        result = prime * result + ((getStr4() == null) ? 0 : getStr4().hashCode());
        result = prime * result + ((getStr5() == null) ? 0 : getStr5().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getLastmodifierid() == null) ? 0 : getLastmodifierid().hashCode());
        result = prime * result + ((getLastmodifiername() == null) ? 0 : getLastmodifiername().hashCode());
        result = prime * result + ((getCreationtime() == null) ? 0 : getCreationtime().hashCode());
        result = prime * result + ((getLastmodificationtime() == null) ? 0 : getLastmodificationtime().hashCode());
        result = prime * result + ((getPackagequantity() == null) ? 0 : getPackagequantity().hashCode());
        result = prime * result + ((getSmallunitquantity() == null) ? 0 : getSmallunitquantity().hashCode());
        result = prime * result + ((getLevelcount() == null) ? 0 : getLevelcount().hashCode());
        result = prime * result + ((getConveyorcode() == null) ? 0 : getConveyorcode().hashCode());
        result = prime * result + ((getApplyorordercode() == null) ? 0 : getApplyorordercode().hashCode());
        result = prime * result + ((getOrginagvid() == null) ? 0 : getOrginagvid().hashCode());
        result = prime * result + ((getOrginlocationcode() == null) ? 0 : getOrginlocationcode().hashCode());
        result = prime * result + ((getPallettype() == null) ? 0 : getPallettype().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", whid=").append(whid);
        sb.append(", locationid=").append(locationid);
        sb.append(", pallet=").append(pallet);
        sb.append(", allocatedsmallunitquantity=").append(allocatedsmallunitquantity);
        sb.append(", allocatedpackagequantity=").append(allocatedpackagequantity);
        sb.append(", qcstatus=").append(qcstatus);
        sb.append(", xstatus=").append(xstatus);
        sb.append(", islocked=").append(islocked);
        sb.append(", issealed=").append(issealed);
        sb.append(", isscattered=").append(isscattered);
        sb.append(", isexpired=").append(isexpired);
        sb.append(", comments=").append(comments);
        sb.append(", weight=").append(weight);
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", str1=").append(str1);
        sb.append(", str2=").append(str2);
        sb.append(", str3=").append(str3);
        sb.append(", str4=").append(str4);
        sb.append(", str5=").append(str5);
        sb.append(", creatorid=").append(creatorid);
        sb.append(", creatorname=").append(creatorname);
        sb.append(", lastmodifierid=").append(lastmodifierid);
        sb.append(", lastmodifiername=").append(lastmodifiername);
        sb.append(", creationtime=").append(creationtime);
        sb.append(", lastmodificationtime=").append(lastmodificationtime);
        sb.append(", packagequantity=").append(packagequantity);
        sb.append(", smallunitquantity=").append(smallunitquantity);
        sb.append(", levelcount=").append(levelcount);
        sb.append(", conveyorcode=").append(conveyorcode);
        sb.append(", applyorordercode=").append(applyorordercode);
        sb.append(", orginagvid=").append(orginagvid);
        sb.append(", orginlocationcode=").append(orginlocationcode);
        sb.append(", pallettype=").append(pallettype);
        sb.append(", volume=").append(volume);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}