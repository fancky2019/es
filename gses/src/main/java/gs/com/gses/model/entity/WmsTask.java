package gs.com.gses.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName WmsTask
 */
@TableName(value ="WmsTask")
@Data
public class WmsTask implements Serializable {
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
     * 关联的单据的明细行项ID（上架单，拣货单，盘点移动单等）
     */
    private Long relationorderitemid;

    /**
     * 任务编号
     */
    private String taskno;

    /**
     * 托盘号
     */
    private String palletcode;

    /**
     * 物料id
     */
    private Long materialid;

    /**
     * 物料扩展属性id
     */
    private Long materialpropertyid;

    /**
     * 工单id
     */
    private Long workorderid;

    /**
     * 状态（1open新建，2生效，3执行中，4已完成，-1作废）
     */
    private Integer xstatus;

    /**
     * 原始单据号
     */
    private String originalbillcode;

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
     * 拣货模式 1整托自动分拣手动 2全手动 3全自动
     */
    private Integer pickmode;

    /**
     * 库存明细表id
     */
    private Long inventoryitemid;

    /**
     * 库存明细详情表ID
     */
    private Long inventoryitemdetailid;

    /**
     * 计划数量
     */
    private BigDecimal planquantity;

    /**
     * 计划包装数量
     */
    private BigDecimal planpkgquantity;

    /**
     * 移位数量
     */
    private BigDecimal movedpkgquantity;

    /**
     * 包装单位id
     */
    private Long packageunitid;

    /**
     * 优先级
     */
    private Integer proirity;

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
     * 托盘当前位置
     */
    private String currentloccode;

    /**
     * 描述任务执行中的信息
     */
    private String description;

    /**
     * 起点巷道
     */
    private String fromlanwayno;

    /**
     * 高
     */
    private BigDecimal height;

    /**
     * 长
     */
    private BigDecimal length;

    /**
     * 托盘类型（如大小托盘，预留）
     */
    private String pallettype;

    /**
     * 发货批次
     */
    private String shipbatchno;

    /**
     * LED信息
     */
    private String showlnfor;

    /**
     * 可选终点
     */
    private String toavailableloccodes;

    /**
     * 终点巷道
     */
    private String tolanwayno;

    /**
     * 实际终点
     */
    private String torealloccode;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 宽
     */
    private BigDecimal width;

    /**
     * 起点列
     */
    private Integer fromcolumn;

    /**
     * 起点深度
     */
    private Integer fromdepth;

    /**
     * 起点层
     */
    private Integer fromlevel;

    /**
     * 起点货架
     */
    private Integer fromrack;

    /**
     * 终点列
     */
    private Integer tocolumn;

    /**
     * 终点深度
     */
    private Integer todepth;

    /**
     * 终点层
     */
    private Integer tolevel;

    /**
     * 终点货架
     */
    private Integer torack;

    /**
     * 任务类型（收货上架，库内移位，发货拣货，补货移位，盘点下架，盘点回库，库存调拨，质检下架）
     */
    private Integer tasktype;

    /**
     * 任务方向(1=in ,2= Out ，3= Move，4=return）
     */
    private Integer taskdirection;

    /**
     * 工艺请求ID（入库任务接收入库模块接口写入，出库由出库模块写入，缺省为空）
     */
    private Object requestno;

    /**
     * 原始单据类型名称
     */
    private String originalbilltypename;

    /**
     * 终点月台
     */
    private String todock;

    /**
     * 关联的单据的明细行项对应的主单code（上架单，拣货单，盘点移动单等）
     */
    private String relationorderitemcode;

    /**
     * 
     */
    private Integer taskgroup;

    /**
     * 
     */
    private Long towarehouseid;

    /**
     * 
     */
    private String carton;

    /**
     * 
     */
    private String serialno;

    /**
     * WMS移位任务对应的出库任务号
     */
    private String movetargetmaintaskno;

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
        WmsTask other = (WmsTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWhid() == null ? other.getWhid() == null : this.getWhid().equals(other.getWhid()))
            && (this.getRelationorderitemid() == null ? other.getRelationorderitemid() == null : this.getRelationorderitemid().equals(other.getRelationorderitemid()))
            && (this.getTaskno() == null ? other.getTaskno() == null : this.getTaskno().equals(other.getTaskno()))
            && (this.getPalletcode() == null ? other.getPalletcode() == null : this.getPalletcode().equals(other.getPalletcode()))
            && (this.getMaterialid() == null ? other.getMaterialid() == null : this.getMaterialid().equals(other.getMaterialid()))
            && (this.getMaterialpropertyid() == null ? other.getMaterialpropertyid() == null : this.getMaterialpropertyid().equals(other.getMaterialpropertyid()))
            && (this.getWorkorderid() == null ? other.getWorkorderid() == null : this.getWorkorderid().equals(other.getWorkorderid()))
            && (this.getXstatus() == null ? other.getXstatus() == null : this.getXstatus().equals(other.getXstatus()))
            && (this.getOriginalbillcode() == null ? other.getOriginalbillcode() == null : this.getOriginalbillcode().equals(other.getOriginalbillcode()))
            && (this.getFromlocid() == null ? other.getFromlocid() == null : this.getFromlocid().equals(other.getFromlocid()))
            && (this.getFromloccode() == null ? other.getFromloccode() == null : this.getFromloccode().equals(other.getFromloccode()))
            && (this.getTolocid() == null ? other.getTolocid() == null : this.getTolocid().equals(other.getTolocid()))
            && (this.getToloccode() == null ? other.getToloccode() == null : this.getToloccode().equals(other.getToloccode()))
            && (this.getPickmode() == null ? other.getPickmode() == null : this.getPickmode().equals(other.getPickmode()))
            && (this.getInventoryitemid() == null ? other.getInventoryitemid() == null : this.getInventoryitemid().equals(other.getInventoryitemid()))
            && (this.getInventoryitemdetailid() == null ? other.getInventoryitemdetailid() == null : this.getInventoryitemdetailid().equals(other.getInventoryitemdetailid()))
            && (this.getPlanquantity() == null ? other.getPlanquantity() == null : this.getPlanquantity().equals(other.getPlanquantity()))
            && (this.getPlanpkgquantity() == null ? other.getPlanpkgquantity() == null : this.getPlanpkgquantity().equals(other.getPlanpkgquantity()))
            && (this.getMovedpkgquantity() == null ? other.getMovedpkgquantity() == null : this.getMovedpkgquantity().equals(other.getMovedpkgquantity()))
            && (this.getPackageunitid() == null ? other.getPackageunitid() == null : this.getPackageunitid().equals(other.getPackageunitid()))
            && (this.getProirity() == null ? other.getProirity() == null : this.getProirity().equals(other.getProirity()))
            && (this.getCreatorid() == null ? other.getCreatorid() == null : this.getCreatorid().equals(other.getCreatorid()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getLastmodifierid() == null ? other.getLastmodifierid() == null : this.getLastmodifierid().equals(other.getLastmodifierid()))
            && (this.getLastmodifiername() == null ? other.getLastmodifiername() == null : this.getLastmodifiername().equals(other.getLastmodifiername()))
            && (this.getCreationtime() == null ? other.getCreationtime() == null : this.getCreationtime().equals(other.getCreationtime()))
            && (this.getLastmodificationtime() == null ? other.getLastmodificationtime() == null : this.getLastmodificationtime().equals(other.getLastmodificationtime()))
            && (this.getCurrentloccode() == null ? other.getCurrentloccode() == null : this.getCurrentloccode().equals(other.getCurrentloccode()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getFromlanwayno() == null ? other.getFromlanwayno() == null : this.getFromlanwayno().equals(other.getFromlanwayno()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getLength() == null ? other.getLength() == null : this.getLength().equals(other.getLength()))
            && (this.getPallettype() == null ? other.getPallettype() == null : this.getPallettype().equals(other.getPallettype()))
            && (this.getShipbatchno() == null ? other.getShipbatchno() == null : this.getShipbatchno().equals(other.getShipbatchno()))
            && (this.getShowlnfor() == null ? other.getShowlnfor() == null : this.getShowlnfor().equals(other.getShowlnfor()))
            && (this.getToavailableloccodes() == null ? other.getToavailableloccodes() == null : this.getToavailableloccodes().equals(other.getToavailableloccodes()))
            && (this.getTolanwayno() == null ? other.getTolanwayno() == null : this.getTolanwayno().equals(other.getTolanwayno()))
            && (this.getTorealloccode() == null ? other.getTorealloccode() == null : this.getTorealloccode().equals(other.getTorealloccode()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getFromcolumn() == null ? other.getFromcolumn() == null : this.getFromcolumn().equals(other.getFromcolumn()))
            && (this.getFromdepth() == null ? other.getFromdepth() == null : this.getFromdepth().equals(other.getFromdepth()))
            && (this.getFromlevel() == null ? other.getFromlevel() == null : this.getFromlevel().equals(other.getFromlevel()))
            && (this.getFromrack() == null ? other.getFromrack() == null : this.getFromrack().equals(other.getFromrack()))
            && (this.getTocolumn() == null ? other.getTocolumn() == null : this.getTocolumn().equals(other.getTocolumn()))
            && (this.getTodepth() == null ? other.getTodepth() == null : this.getTodepth().equals(other.getTodepth()))
            && (this.getTolevel() == null ? other.getTolevel() == null : this.getTolevel().equals(other.getTolevel()))
            && (this.getTorack() == null ? other.getTorack() == null : this.getTorack().equals(other.getTorack()))
            && (this.getTasktype() == null ? other.getTasktype() == null : this.getTasktype().equals(other.getTasktype()))
            && (this.getTaskdirection() == null ? other.getTaskdirection() == null : this.getTaskdirection().equals(other.getTaskdirection()))
            && (this.getRequestno() == null ? other.getRequestno() == null : this.getRequestno().equals(other.getRequestno()))
            && (this.getOriginalbilltypename() == null ? other.getOriginalbilltypename() == null : this.getOriginalbilltypename().equals(other.getOriginalbilltypename()))
            && (this.getTodock() == null ? other.getTodock() == null : this.getTodock().equals(other.getTodock()))
            && (this.getRelationorderitemcode() == null ? other.getRelationorderitemcode() == null : this.getRelationorderitemcode().equals(other.getRelationorderitemcode()))
            && (this.getTaskgroup() == null ? other.getTaskgroup() == null : this.getTaskgroup().equals(other.getTaskgroup()))
            && (this.getTowarehouseid() == null ? other.getTowarehouseid() == null : this.getTowarehouseid().equals(other.getTowarehouseid()))
            && (this.getCarton() == null ? other.getCarton() == null : this.getCarton().equals(other.getCarton()))
            && (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getMovetargetmaintaskno() == null ? other.getMovetargetmaintaskno() == null : this.getMovetargetmaintaskno().equals(other.getMovetargetmaintaskno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWhid() == null) ? 0 : getWhid().hashCode());
        result = prime * result + ((getRelationorderitemid() == null) ? 0 : getRelationorderitemid().hashCode());
        result = prime * result + ((getTaskno() == null) ? 0 : getTaskno().hashCode());
        result = prime * result + ((getPalletcode() == null) ? 0 : getPalletcode().hashCode());
        result = prime * result + ((getMaterialid() == null) ? 0 : getMaterialid().hashCode());
        result = prime * result + ((getMaterialpropertyid() == null) ? 0 : getMaterialpropertyid().hashCode());
        result = prime * result + ((getWorkorderid() == null) ? 0 : getWorkorderid().hashCode());
        result = prime * result + ((getXstatus() == null) ? 0 : getXstatus().hashCode());
        result = prime * result + ((getOriginalbillcode() == null) ? 0 : getOriginalbillcode().hashCode());
        result = prime * result + ((getFromlocid() == null) ? 0 : getFromlocid().hashCode());
        result = prime * result + ((getFromloccode() == null) ? 0 : getFromloccode().hashCode());
        result = prime * result + ((getTolocid() == null) ? 0 : getTolocid().hashCode());
        result = prime * result + ((getToloccode() == null) ? 0 : getToloccode().hashCode());
        result = prime * result + ((getPickmode() == null) ? 0 : getPickmode().hashCode());
        result = prime * result + ((getInventoryitemid() == null) ? 0 : getInventoryitemid().hashCode());
        result = prime * result + ((getInventoryitemdetailid() == null) ? 0 : getInventoryitemdetailid().hashCode());
        result = prime * result + ((getPlanquantity() == null) ? 0 : getPlanquantity().hashCode());
        result = prime * result + ((getPlanpkgquantity() == null) ? 0 : getPlanpkgquantity().hashCode());
        result = prime * result + ((getMovedpkgquantity() == null) ? 0 : getMovedpkgquantity().hashCode());
        result = prime * result + ((getPackageunitid() == null) ? 0 : getPackageunitid().hashCode());
        result = prime * result + ((getProirity() == null) ? 0 : getProirity().hashCode());
        result = prime * result + ((getCreatorid() == null) ? 0 : getCreatorid().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getLastmodifierid() == null) ? 0 : getLastmodifierid().hashCode());
        result = prime * result + ((getLastmodifiername() == null) ? 0 : getLastmodifiername().hashCode());
        result = prime * result + ((getCreationtime() == null) ? 0 : getCreationtime().hashCode());
        result = prime * result + ((getLastmodificationtime() == null) ? 0 : getLastmodificationtime().hashCode());
        result = prime * result + ((getCurrentloccode() == null) ? 0 : getCurrentloccode().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getFromlanwayno() == null) ? 0 : getFromlanwayno().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getLength() == null) ? 0 : getLength().hashCode());
        result = prime * result + ((getPallettype() == null) ? 0 : getPallettype().hashCode());
        result = prime * result + ((getShipbatchno() == null) ? 0 : getShipbatchno().hashCode());
        result = prime * result + ((getShowlnfor() == null) ? 0 : getShowlnfor().hashCode());
        result = prime * result + ((getToavailableloccodes() == null) ? 0 : getToavailableloccodes().hashCode());
        result = prime * result + ((getTolanwayno() == null) ? 0 : getTolanwayno().hashCode());
        result = prime * result + ((getTorealloccode() == null) ? 0 : getTorealloccode().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getFromcolumn() == null) ? 0 : getFromcolumn().hashCode());
        result = prime * result + ((getFromdepth() == null) ? 0 : getFromdepth().hashCode());
        result = prime * result + ((getFromlevel() == null) ? 0 : getFromlevel().hashCode());
        result = prime * result + ((getFromrack() == null) ? 0 : getFromrack().hashCode());
        result = prime * result + ((getTocolumn() == null) ? 0 : getTocolumn().hashCode());
        result = prime * result + ((getTodepth() == null) ? 0 : getTodepth().hashCode());
        result = prime * result + ((getTolevel() == null) ? 0 : getTolevel().hashCode());
        result = prime * result + ((getTorack() == null) ? 0 : getTorack().hashCode());
        result = prime * result + ((getTasktype() == null) ? 0 : getTasktype().hashCode());
        result = prime * result + ((getTaskdirection() == null) ? 0 : getTaskdirection().hashCode());
        result = prime * result + ((getRequestno() == null) ? 0 : getRequestno().hashCode());
        result = prime * result + ((getOriginalbilltypename() == null) ? 0 : getOriginalbilltypename().hashCode());
        result = prime * result + ((getTodock() == null) ? 0 : getTodock().hashCode());
        result = prime * result + ((getRelationorderitemcode() == null) ? 0 : getRelationorderitemcode().hashCode());
        result = prime * result + ((getTaskgroup() == null) ? 0 : getTaskgroup().hashCode());
        result = prime * result + ((getTowarehouseid() == null) ? 0 : getTowarehouseid().hashCode());
        result = prime * result + ((getCarton() == null) ? 0 : getCarton().hashCode());
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getMovetargetmaintaskno() == null) ? 0 : getMovetargetmaintaskno().hashCode());
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
        sb.append(", relationorderitemid=").append(relationorderitemid);
        sb.append(", taskno=").append(taskno);
        sb.append(", palletcode=").append(palletcode);
        sb.append(", materialid=").append(materialid);
        sb.append(", materialpropertyid=").append(materialpropertyid);
        sb.append(", workorderid=").append(workorderid);
        sb.append(", xstatus=").append(xstatus);
        sb.append(", originalbillcode=").append(originalbillcode);
        sb.append(", fromlocid=").append(fromlocid);
        sb.append(", fromloccode=").append(fromloccode);
        sb.append(", tolocid=").append(tolocid);
        sb.append(", toloccode=").append(toloccode);
        sb.append(", pickmode=").append(pickmode);
        sb.append(", inventoryitemid=").append(inventoryitemid);
        sb.append(", inventoryitemdetailid=").append(inventoryitemdetailid);
        sb.append(", planquantity=").append(planquantity);
        sb.append(", planpkgquantity=").append(planpkgquantity);
        sb.append(", movedpkgquantity=").append(movedpkgquantity);
        sb.append(", packageunitid=").append(packageunitid);
        sb.append(", proirity=").append(proirity);
        sb.append(", creatorid=").append(creatorid);
        sb.append(", creatorname=").append(creatorname);
        sb.append(", lastmodifierid=").append(lastmodifierid);
        sb.append(", lastmodifiername=").append(lastmodifiername);
        sb.append(", creationtime=").append(creationtime);
        sb.append(", lastmodificationtime=").append(lastmodificationtime);
        sb.append(", currentloccode=").append(currentloccode);
        sb.append(", description=").append(description);
        sb.append(", fromlanwayno=").append(fromlanwayno);
        sb.append(", height=").append(height);
        sb.append(", length=").append(length);
        sb.append(", pallettype=").append(pallettype);
        sb.append(", shipbatchno=").append(shipbatchno);
        sb.append(", showlnfor=").append(showlnfor);
        sb.append(", toavailableloccodes=").append(toavailableloccodes);
        sb.append(", tolanwayno=").append(tolanwayno);
        sb.append(", torealloccode=").append(torealloccode);
        sb.append(", weight=").append(weight);
        sb.append(", width=").append(width);
        sb.append(", fromcolumn=").append(fromcolumn);
        sb.append(", fromdepth=").append(fromdepth);
        sb.append(", fromlevel=").append(fromlevel);
        sb.append(", fromrack=").append(fromrack);
        sb.append(", tocolumn=").append(tocolumn);
        sb.append(", todepth=").append(todepth);
        sb.append(", tolevel=").append(tolevel);
        sb.append(", torack=").append(torack);
        sb.append(", tasktype=").append(tasktype);
        sb.append(", taskdirection=").append(taskdirection);
        sb.append(", requestno=").append(requestno);
        sb.append(", originalbilltypename=").append(originalbilltypename);
        sb.append(", todock=").append(todock);
        sb.append(", relationorderitemcode=").append(relationorderitemcode);
        sb.append(", taskgroup=").append(taskgroup);
        sb.append(", towarehouseid=").append(towarehouseid);
        sb.append(", carton=").append(carton);
        sb.append(", serialno=").append(serialno);
        sb.append(", movetargetmaintaskno=").append(movetargetmaintaskno);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}