package gs.com.gses.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName Material
 */
@TableName(value ="Material")
@Data
public class Material implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 编码（编码去重）
     */
    private String xcode;

    /**
     * 名称
     */
    private String xname;

    /**
     * 物料大类目录id
     */
    private Long materialcategoryid;

    /**
     * 简称
     */
    private String shortname;

    /**
     * 条码值
     */
    private String barcode;

    /**
     * 助记码
     */
    private String mnemoniccode;

    /**
     * 库存上限
     */
    private BigDecimal upper;

    /**
     * 库存下限
     */
    private BigDecimal lower;

    /**
     * 规格
     */
    private String spec;

    /**
     * 有效期天数
     */
    private Integer days;

    /**
     * 最小单位
     */
    private String smallestunit;

    /**
     * 备注
     */
    private String comments;

    /**
     * 是否禁用
     */
    private Boolean isforbidden;

    /**
     * 禁用说明
     */
    private String forbiddencomments;

    /**
     * 禁用人
     */
    private Object forbiddenuserid;

    /**
     * 预留字段1
     */
    private String str1;

    /**
     * 
     */
    private String str2;

    /**
     * 
     */
    private String str3;

    /**
     * 
     */
    private String str4;

    /**
     * 
     */
    private String str5;

    /**
     * 
     */
    private String str6;

    /**
     * 
     */
    private String str7;

    /**
     * 
     */
    private String str8;

    /**
     * 
     */
    private String str9;

    /**
     * 
     */
    private String str10;

    /**
     * 
     */
    private String str11;

    /**
     * 
     */
    private String str12;

    /**
     * 
     */
    private String str13;

    /**
     * 
     */
    private String str14;

    /**
     * 
     */
    private String str15;

    /**
     * 
     */
    private String str16;

    /**
     * 
     */
    private String str17;

    /**
     * 
     */
    private String str18;

    /**
     * 
     */
    private String str19;

    /**
     * 
     */
    private String str20;

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
     * ERP账号标记
     */
    private String erpaccountset;

    /**
     * 
     */
    private String displaycode;

    /**
     * 
     */
    private String erpuniquecode;

    /**
     * 
     */
    private String picurl;

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
        Material other = (Material) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getXcode() == null ? other.getXcode() == null : this.getXcode().equals(other.getXcode()))
            && (this.getXname() == null ? other.getXname() == null : this.getXname().equals(other.getXname()))
            && (this.getMaterialcategoryid() == null ? other.getMaterialcategoryid() == null : this.getMaterialcategoryid().equals(other.getMaterialcategoryid()))
            && (this.getShortname() == null ? other.getShortname() == null : this.getShortname().equals(other.getShortname()))
            && (this.getBarcode() == null ? other.getBarcode() == null : this.getBarcode().equals(other.getBarcode()))
            && (this.getMnemoniccode() == null ? other.getMnemoniccode() == null : this.getMnemoniccode().equals(other.getMnemoniccode()))
            && (this.getUpper() == null ? other.getUpper() == null : this.getUpper().equals(other.getUpper()))
            && (this.getLower() == null ? other.getLower() == null : this.getLower().equals(other.getLower()))
            && (this.getSpec() == null ? other.getSpec() == null : this.getSpec().equals(other.getSpec()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()))
            && (this.getSmallestunit() == null ? other.getSmallestunit() == null : this.getSmallestunit().equals(other.getSmallestunit()))
            && (this.getComments() == null ? other.getComments() == null : this.getComments().equals(other.getComments()))
            && (this.getIsforbidden() == null ? other.getIsforbidden() == null : this.getIsforbidden().equals(other.getIsforbidden()))
            && (this.getForbiddencomments() == null ? other.getForbiddencomments() == null : this.getForbiddencomments().equals(other.getForbiddencomments()))
            && (this.getForbiddenuserid() == null ? other.getForbiddenuserid() == null : this.getForbiddenuserid().equals(other.getForbiddenuserid()))
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
            && (this.getCreatorid() == null ? other.getCreatorid() == null : this.getCreatorid().equals(other.getCreatorid()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getLastmodifierid() == null ? other.getLastmodifierid() == null : this.getLastmodifierid().equals(other.getLastmodifierid()))
            && (this.getLastmodifiername() == null ? other.getLastmodifiername() == null : this.getLastmodifiername().equals(other.getLastmodifiername()))
            && (this.getCreationtime() == null ? other.getCreationtime() == null : this.getCreationtime().equals(other.getCreationtime()))
            && (this.getLastmodificationtime() == null ? other.getLastmodificationtime() == null : this.getLastmodificationtime().equals(other.getLastmodificationtime()))
            && (this.getErpaccountset() == null ? other.getErpaccountset() == null : this.getErpaccountset().equals(other.getErpaccountset()))
            && (this.getDisplaycode() == null ? other.getDisplaycode() == null : this.getDisplaycode().equals(other.getDisplaycode()))
            && (this.getErpuniquecode() == null ? other.getErpuniquecode() == null : this.getErpuniquecode().equals(other.getErpuniquecode()))
            && (this.getPicurl() == null ? other.getPicurl() == null : this.getPicurl().equals(other.getPicurl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getXcode() == null) ? 0 : getXcode().hashCode());
        result = prime * result + ((getXname() == null) ? 0 : getXname().hashCode());
        result = prime * result + ((getMaterialcategoryid() == null) ? 0 : getMaterialcategoryid().hashCode());
        result = prime * result + ((getShortname() == null) ? 0 : getShortname().hashCode());
        result = prime * result + ((getBarcode() == null) ? 0 : getBarcode().hashCode());
        result = prime * result + ((getMnemoniccode() == null) ? 0 : getMnemoniccode().hashCode());
        result = prime * result + ((getUpper() == null) ? 0 : getUpper().hashCode());
        result = prime * result + ((getLower() == null) ? 0 : getLower().hashCode());
        result = prime * result + ((getSpec() == null) ? 0 : getSpec().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        result = prime * result + ((getSmallestunit() == null) ? 0 : getSmallestunit().hashCode());
        result = prime * result + ((getComments() == null) ? 0 : getComments().hashCode());
        result = prime * result + ((getIsforbidden() == null) ? 0 : getIsforbidden().hashCode());
        result = prime * result + ((getForbiddencomments() == null) ? 0 : getForbiddencomments().hashCode());
        result = prime * result + ((getForbiddenuserid() == null) ? 0 : getForbiddenuserid().hashCode());
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
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getLastmodifierid() == null) ? 0 : getLastmodifierid().hashCode());
        result = prime * result + ((getLastmodifiername() == null) ? 0 : getLastmodifiername().hashCode());
        result = prime * result + ((getCreationtime() == null) ? 0 : getCreationtime().hashCode());
        result = prime * result + ((getLastmodificationtime() == null) ? 0 : getLastmodificationtime().hashCode());
        result = prime * result + ((getErpaccountset() == null) ? 0 : getErpaccountset().hashCode());
        result = prime * result + ((getDisplaycode() == null) ? 0 : getDisplaycode().hashCode());
        result = prime * result + ((getErpuniquecode() == null) ? 0 : getErpuniquecode().hashCode());
        result = prime * result + ((getPicurl() == null) ? 0 : getPicurl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", xcode=").append(xcode);
        sb.append(", xname=").append(xname);
        sb.append(", materialcategoryid=").append(materialcategoryid);
        sb.append(", shortname=").append(shortname);
        sb.append(", barcode=").append(barcode);
        sb.append(", mnemoniccode=").append(mnemoniccode);
        sb.append(", upper=").append(upper);
        sb.append(", lower=").append(lower);
        sb.append(", spec=").append(spec);
        sb.append(", days=").append(days);
        sb.append(", smallestunit=").append(smallestunit);
        sb.append(", comments=").append(comments);
        sb.append(", isforbidden=").append(isforbidden);
        sb.append(", forbiddencomments=").append(forbiddencomments);
        sb.append(", forbiddenuserid=").append(forbiddenuserid);
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
        sb.append(", creatorid=").append(creatorid);
        sb.append(", creatorname=").append(creatorname);
        sb.append(", lastmodifierid=").append(lastmodifierid);
        sb.append(", lastmodifiername=").append(lastmodifiername);
        sb.append(", creationtime=").append(creationtime);
        sb.append(", lastmodificationtime=").append(lastmodificationtime);
        sb.append(", erpaccountset=").append(erpaccountset);
        sb.append(", displaycode=").append(displaycode);
        sb.append(", erpuniquecode=").append(erpuniquecode);
        sb.append(", picurl=").append(picurl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}