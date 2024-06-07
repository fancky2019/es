package gs.com.gses.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName ShipOrderArchieved
 */
@TableName(value ="ShipOrderArchieved")
@Data
public class ShipOrderArchieved implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

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
    private Long whid;

    /**
     * 出库单号
     */
    private String xcode;

    /**
     * 终点位置ID
     */
    private Long tolocid;

    /**
     * 终点位置Code
     */
    private String toloccode;

    /**
     * 指定月台
     */
    private String destination;

    /**
     * 关联的出库申请单号(如果多个申请单合并出库，逗号分隔，拼接存储)
     */
    private String applyshipordercode;

    /**
     * 状态（1 open新建，2生效，3执行中，4已完成，5已发运,-1作废）
     */
    private Integer xstatus;

    /**
     * 组织（货主）
     */
    private Long organiztionid;

    /**
     * 单据类型id
     */
    private Long billtypeid;

    /**
     * 期望出库数量（不可编辑，由明细加总得到）
     */
    private BigDecimal expectedpkgquantity;

    /**
     * 已分配数量（不可编辑，由明细加总得到）
     */
    private BigDecimal alloactedpkgquantity;

    /**
     * 已拣货数量（不可编辑，由明细加总得到）
     */
    private BigDecimal pickedpkgquantity;

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
     * 预留字段6
     */
    private String str6;

    /**
     * 预留字段7
     */
    private String str7;

    /**
     * 预留字段8
     */
    private String str8;

    /**
     * 预留字段9
     */
    private String str9;

    /**
     * 预留字段10
     */
    private String str10;

    /**
     * 预留字段11
     */
    private String str11;

    /**
     * 预留字段12
     */
    private String str12;

    /**
     * 预留字段13
     */
    private String str13;

    /**
     * 预留字段14
     */
    private String str14;

    /**
     * 预留字段15
     */
    private String str15;

    /**
     * 预留字段16
     */
    private String str16;

    /**
     * 预留字段17
     */
    private String str17;

    /**
     * 预留字段18
     */
    private String str18;

    /**
     * 预留字段19
     */
    private String str19;

    /**
     * 预留字段20
     */
    private String str20;

    /**
     * 单据优先级[0,8]
     */
    private Integer proirity;

    /**
     * 一键下发时间
     */
    private Long oneclicktime;

    /**
     * 客户
     */
    private Long organiztioncustomid;

    /**
     * 部门
     */
    private Long organiztiondepartmentid;

    /**
     * 组织（供应商）
     */
    private Long organiztionsupplierid;

    /**
     * 指定月台站点
     */
    private String destinationdock;

    /**
     * 库区
     */
    private String zonecode;

    /**
     * 库区
     */
    private Long zoneid;

    /**
     * 分组统计标识
     */
    private String groupflag;

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
        ShipOrderArchieved other = (ShipOrderArchieved) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreatorid() == null ? other.getCreatorid() == null : this.getCreatorid().equals(other.getCreatorid()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getLastmodifierid() == null ? other.getLastmodifierid() == null : this.getLastmodifierid().equals(other.getLastmodifierid()))
            && (this.getLastmodifiername() == null ? other.getLastmodifiername() == null : this.getLastmodifiername().equals(other.getLastmodifiername()))
            && (this.getCreationtime() == null ? other.getCreationtime() == null : this.getCreationtime().equals(other.getCreationtime()))
            && (this.getLastmodificationtime() == null ? other.getLastmodificationtime() == null : this.getLastmodificationtime().equals(other.getLastmodificationtime()))
            && (this.getWhid() == null ? other.getWhid() == null : this.getWhid().equals(other.getWhid()))
            && (this.getXcode() == null ? other.getXcode() == null : this.getXcode().equals(other.getXcode()))
            && (this.getTolocid() == null ? other.getTolocid() == null : this.getTolocid().equals(other.getTolocid()))
            && (this.getToloccode() == null ? other.getToloccode() == null : this.getToloccode().equals(other.getToloccode()))
            && (this.getDestination() == null ? other.getDestination() == null : this.getDestination().equals(other.getDestination()))
            && (this.getApplyshipordercode() == null ? other.getApplyshipordercode() == null : this.getApplyshipordercode().equals(other.getApplyshipordercode()))
            && (this.getXstatus() == null ? other.getXstatus() == null : this.getXstatus().equals(other.getXstatus()))
            && (this.getOrganiztionid() == null ? other.getOrganiztionid() == null : this.getOrganiztionid().equals(other.getOrganiztionid()))
            && (this.getBilltypeid() == null ? other.getBilltypeid() == null : this.getBilltypeid().equals(other.getBilltypeid()))
            && (this.getExpectedpkgquantity() == null ? other.getExpectedpkgquantity() == null : this.getExpectedpkgquantity().equals(other.getExpectedpkgquantity()))
            && (this.getAlloactedpkgquantity() == null ? other.getAlloactedpkgquantity() == null : this.getAlloactedpkgquantity().equals(other.getAlloactedpkgquantity()))
            && (this.getPickedpkgquantity() == null ? other.getPickedpkgquantity() == null : this.getPickedpkgquantity().equals(other.getPickedpkgquantity()))
            && (this.getComments() == null ? other.getComments() == null : this.getComments().equals(other.getComments()))
            && (this.getStr1() == null ? other.getStr1() == null : this.getStr1().equals(other.getStr1()))
            && (this.getStr2() == null ? other.getStr2() == null : this.getStr2().equals(other.getStr2()))
            && (this.getStr3() == null ? other.getStr3() == null : this.getStr3().equals(other.getStr3()))
            && (this.getStr4() == null ? other.getStr4() == null : this.getStr4().equals(other.getStr4()))
            && (this.getStr5() == null ? other.getStr5() == null : this.getStr5().equals(other.getStr5()))
            && (this.getStr6() == null ? other.getStr6() == null : this.getStr6().equals(other.getStr6()))
            && (this.getStr7() == null ? other.getStr7() == null : this.getStr7().equals(other.getStr7()))
            && (this.getStr8() == null ? other.getStr8() == null : this.getStr8().equals(other.getStr8()))
            && (this.getStr9() == null ? other.getStr9() == null : this.getStr9().equals(other.getStr9()))
            && (this.getStr10() == null ? other.getStr10() == null : this.getStr10().equals(other.getStr10()))
            && (this.getStr11() == null ? other.getStr11() == null : this.getStr11().equals(other.getStr11()))
            && (this.getStr12() == null ? other.getStr12() == null : this.getStr12().equals(other.getStr12()))
            && (this.getStr13() == null ? other.getStr13() == null : this.getStr13().equals(other.getStr13()))
            && (this.getStr14() == null ? other.getStr14() == null : this.getStr14().equals(other.getStr14()))
            && (this.getStr15() == null ? other.getStr15() == null : this.getStr15().equals(other.getStr15()))
            && (this.getStr16() == null ? other.getStr16() == null : this.getStr16().equals(other.getStr16()))
            && (this.getStr17() == null ? other.getStr17() == null : this.getStr17().equals(other.getStr17()))
            && (this.getStr18() == null ? other.getStr18() == null : this.getStr18().equals(other.getStr18()))
            && (this.getStr19() == null ? other.getStr19() == null : this.getStr19().equals(other.getStr19()))
            && (this.getStr20() == null ? other.getStr20() == null : this.getStr20().equals(other.getStr20()))
            && (this.getProirity() == null ? other.getProirity() == null : this.getProirity().equals(other.getProirity()))
            && (this.getOneclicktime() == null ? other.getOneclicktime() == null : this.getOneclicktime().equals(other.getOneclicktime()))
            && (this.getOrganiztioncustomid() == null ? other.getOrganiztioncustomid() == null : this.getOrganiztioncustomid().equals(other.getOrganiztioncustomid()))
            && (this.getOrganiztiondepartmentid() == null ? other.getOrganiztiondepartmentid() == null : this.getOrganiztiondepartmentid().equals(other.getOrganiztiondepartmentid()))
            && (this.getOrganiztionsupplierid() == null ? other.getOrganiztionsupplierid() == null : this.getOrganiztionsupplierid().equals(other.getOrganiztionsupplierid()))
            && (this.getDestinationdock() == null ? other.getDestinationdock() == null : this.getDestinationdock().equals(other.getDestinationdock()))
            && (this.getZonecode() == null ? other.getZonecode() == null : this.getZonecode().equals(other.getZonecode()))
            && (this.getZoneid() == null ? other.getZoneid() == null : this.getZoneid().equals(other.getZoneid()))
            && (this.getGroupflag() == null ? other.getGroupflag() == null : this.getGroupflag().equals(other.getGroupflag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getLastmodifierid() == null) ? 0 : getLastmodifierid().hashCode());
        result = prime * result + ((getLastmodifiername() == null) ? 0 : getLastmodifiername().hashCode());
        result = prime * result + ((getCreationtime() == null) ? 0 : getCreationtime().hashCode());
        result = prime * result + ((getLastmodificationtime() == null) ? 0 : getLastmodificationtime().hashCode());
        result = prime * result + ((getWhid() == null) ? 0 : getWhid().hashCode());
        result = prime * result + ((getXcode() == null) ? 0 : getXcode().hashCode());
        result = prime * result + ((getTolocid() == null) ? 0 : getTolocid().hashCode());
        result = prime * result + ((getToloccode() == null) ? 0 : getToloccode().hashCode());
        result = prime * result + ((getDestination() == null) ? 0 : getDestination().hashCode());
        result = prime * result + ((getApplyshipordercode() == null) ? 0 : getApplyshipordercode().hashCode());
        result = prime * result + ((getXstatus() == null) ? 0 : getXstatus().hashCode());
        result = prime * result + ((getOrganiztionid() == null) ? 0 : getOrganiztionid().hashCode());
        result = prime * result + ((getBilltypeid() == null) ? 0 : getBilltypeid().hashCode());
        result = prime * result + ((getExpectedpkgquantity() == null) ? 0 : getExpectedpkgquantity().hashCode());
        result = prime * result + ((getAlloactedpkgquantity() == null) ? 0 : getAlloactedpkgquantity().hashCode());
        result = prime * result + ((getPickedpkgquantity() == null) ? 0 : getPickedpkgquantity().hashCode());
        result = prime * result + ((getComments() == null) ? 0 : getComments().hashCode());
        result = prime * result + ((getStr1() == null) ? 0 : getStr1().hashCode());
        result = prime * result + ((getStr2() == null) ? 0 : getStr2().hashCode());
        result = prime * result + ((getStr3() == null) ? 0 : getStr3().hashCode());
        result = prime * result + ((getStr4() == null) ? 0 : getStr4().hashCode());
        result = prime * result + ((getStr5() == null) ? 0 : getStr5().hashCode());
        result = prime * result + ((getStr6() == null) ? 0 : getStr6().hashCode());
        result = prime * result + ((getStr7() == null) ? 0 : getStr7().hashCode());
        result = prime * result + ((getStr8() == null) ? 0 : getStr8().hashCode());
        result = prime * result + ((getStr9() == null) ? 0 : getStr9().hashCode());
        result = prime * result + ((getStr10() == null) ? 0 : getStr10().hashCode());
        result = prime * result + ((getStr11() == null) ? 0 : getStr11().hashCode());
        result = prime * result + ((getStr12() == null) ? 0 : getStr12().hashCode());
        result = prime * result + ((getStr13() == null) ? 0 : getStr13().hashCode());
        result = prime * result + ((getStr14() == null) ? 0 : getStr14().hashCode());
        result = prime * result + ((getStr15() == null) ? 0 : getStr15().hashCode());
        result = prime * result + ((getStr16() == null) ? 0 : getStr16().hashCode());
        result = prime * result + ((getStr17() == null) ? 0 : getStr17().hashCode());
        result = prime * result + ((getStr18() == null) ? 0 : getStr18().hashCode());
        result = prime * result + ((getStr19() == null) ? 0 : getStr19().hashCode());
        result = prime * result + ((getStr20() == null) ? 0 : getStr20().hashCode());
        result = prime * result + ((getProirity() == null) ? 0 : getProirity().hashCode());
        result = prime * result + ((getOneclicktime() == null) ? 0 : getOneclicktime().hashCode());
        result = prime * result + ((getOrganiztioncustomid() == null) ? 0 : getOrganiztioncustomid().hashCode());
        result = prime * result + ((getOrganiztiondepartmentid() == null) ? 0 : getOrganiztiondepartmentid().hashCode());
        result = prime * result + ((getOrganiztionsupplierid() == null) ? 0 : getOrganiztionsupplierid().hashCode());
        result = prime * result + ((getDestinationdock() == null) ? 0 : getDestinationdock().hashCode());
        result = prime * result + ((getZonecode() == null) ? 0 : getZonecode().hashCode());
        result = prime * result + ((getZoneid() == null) ? 0 : getZoneid().hashCode());
        result = prime * result + ((getGroupflag() == null) ? 0 : getGroupflag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", creatorid=").append(creatorid);
        sb.append(", creatorname=").append(creatorname);
        sb.append(", lastmodifierid=").append(lastmodifierid);
        sb.append(", lastmodifiername=").append(lastmodifiername);
        sb.append(", creationtime=").append(creationtime);
        sb.append(", lastmodificationtime=").append(lastmodificationtime);
        sb.append(", whid=").append(whid);
        sb.append(", xcode=").append(xcode);
        sb.append(", tolocid=").append(tolocid);
        sb.append(", toloccode=").append(toloccode);
        sb.append(", destination=").append(destination);
        sb.append(", applyshipordercode=").append(applyshipordercode);
        sb.append(", xstatus=").append(xstatus);
        sb.append(", organiztionid=").append(organiztionid);
        sb.append(", billtypeid=").append(billtypeid);
        sb.append(", expectedpkgquantity=").append(expectedpkgquantity);
        sb.append(", alloactedpkgquantity=").append(alloactedpkgquantity);
        sb.append(", pickedpkgquantity=").append(pickedpkgquantity);
        sb.append(", comments=").append(comments);
        sb.append(", str1=").append(str1);
        sb.append(", str2=").append(str2);
        sb.append(", str3=").append(str3);
        sb.append(", str4=").append(str4);
        sb.append(", str5=").append(str5);
        sb.append(", str6=").append(str6);
        sb.append(", str7=").append(str7);
        sb.append(", str8=").append(str8);
        sb.append(", str9=").append(str9);
        sb.append(", str10=").append(str10);
        sb.append(", str11=").append(str11);
        sb.append(", str12=").append(str12);
        sb.append(", str13=").append(str13);
        sb.append(", str14=").append(str14);
        sb.append(", str15=").append(str15);
        sb.append(", str16=").append(str16);
        sb.append(", str17=").append(str17);
        sb.append(", str18=").append(str18);
        sb.append(", str19=").append(str19);
        sb.append(", str20=").append(str20);
        sb.append(", proirity=").append(proirity);
        sb.append(", oneclicktime=").append(oneclicktime);
        sb.append(", organiztioncustomid=").append(organiztioncustomid);
        sb.append(", organiztiondepartmentid=").append(organiztiondepartmentid);
        sb.append(", organiztionsupplierid=").append(organiztionsupplierid);
        sb.append(", destinationdock=").append(destinationdock);
        sb.append(", zonecode=").append(zonecode);
        sb.append(", zoneid=").append(zoneid);
        sb.append(", groupflag=").append(groupflag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}