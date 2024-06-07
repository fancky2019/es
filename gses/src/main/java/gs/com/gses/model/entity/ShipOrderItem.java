package gs.com.gses.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName ShipOrderItem
 */
@TableName(value ="ShipOrderItem")
@Data
public class ShipOrderItem implements Serializable {
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
     * 行号
     */
    private Integer rowno;

    /**
     * 第三方系统单号（兼容字符型）
     */
    private String erpcode;

    /**
     * 第三方系统行号（兼容字符型）
     */
    private String thirdpartyrowno;

    /**
     * 状态（1open新建，2生效，3执行中，4已完成，-1作废）
     */
    private Integer xstatus;

    /**
     * 物料id
     */
    private Long materialid;

    /**
     * 批号
     */
    private String batchno;

    /**
     * 批号2
     */
    private String batchno2;

    /**
     * 批号3
     */
    private String batchno3;

    /**
     * 包装单位id
     */
    private Long packageunitid;

    /**
     * 需求数量
     */
    private BigDecimal requiredpkgquantity;

    /**
     * 需求数量单位
     */
    private String requiredunit;

    /**
     * 分配数量
     */
    private BigDecimal alloactedpkgquantity;

    /**
     * 已拣货数量
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
     * 物料扩展属性预留字段1
     */
    private String mStr1;

    /**
     * 物料扩展属性预留字段2
     */
    private String mStr2;

    /**
     * 物料扩展属性预留字段3
     */
    private String mStr3;

    /**
     * 物料扩展属性预留字段4
     */
    private String mStr4;

    /**
     * 物料扩展属性预留字段5
     */
    private String mStr5;

    /**
     * 物料扩展属性预留字段6
     */
    private String mStr6;

    /**
     * 物料扩展属性预留字段7
     */
    private String mStr7;

    /**
     * 物料扩展属性预留字段8
     */
    private String mStr8;

    /**
     * 物料扩展属性预留字段9
     */
    private String mStr9;

    /**
     * 物料扩展属性预留字段10
     */
    private String mStr10;

    /**
     * 物料扩展属性预留字段11
     */
    private String mStr11;

    /**
     * 物料扩展属性预留字段12
     */
    private String mStr12;

    /**
     * 物料扩展属性预留字段13
     */
    private String mStr13;

    /**
     * 物料扩展属性预留字段14
     */
    private String mStr14;

    /**
     * 物料扩展属性预留字段15
     */
    private String mStr15;

    /**
     * 物料扩展属性预留字段16
     */
    private String mStr16;

    /**
     * 物料扩展属性预留字段17
     */
    private String mStr17;

    /**
     * 物料扩展属性预留字段18
     */
    private String mStr18;

    /**
     * 物料扩展属性预留字段19
     */
    private String mStr19;

    /**
     * 物料扩展属性预留字段20
     */
    private String mStr20;

    /**
     * 物料扩展属性预留字段21
     */
    private String mStr21;

    /**
     * 物料扩展属性预留字段22
     */
    private String mStr22;

    /**
     * 物料扩展属性预留字段23
     */
    private String mStr23;

    /**
     * 物料扩展属性预留字段24
     */
    private String mStr24;

    /**
     * 物料扩展属性预留字段25
     */
    private String mStr25;

    /**
     * 物料扩展属性预留字段26
     */
    private String mStr26;

    /**
     * 物料扩展属性预留字段27
     */
    private String mStr27;

    /**
     * 物料扩展属性预留字段28
     */
    private String mStr28;

    /**
     * 物料扩展属性预留字段29
     */
    private String mStr29;

    /**
     * 物料扩展属性预留字段30
     */
    private String mStr30;

    /**
     * 物料扩展属性预留字段31
     */
    private String mStr31;

    /**
     * 物料扩展属性预留字段32
     */
    private String mStr32;

    /**
     * 物料扩展属性预留字段33
     */
    private String mStr33;

    /**
     * 物料扩展属性预留字段34
     */
    private String mStr34;

    /**
     * 物料扩展属性预留字段35
     */
    private String mStr35;

    /**
     * 物料扩展属性预留字段36
     */
    private String mStr36;

    /**
     * 物料扩展属性预留字段37
     */
    private String mStr37;

    /**
     * 物料扩展属性预留字段38
     */
    private String mStr38;

    /**
     * 物料扩展属性预留字段39
     */
    private String mStr39;

    /**
     * 物料扩展属性预留字段40
     */
    private String mStr40;

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
     * 过期时间
     */
    private Long expiredtime;

    /**
     * 入库时间
     */
    private Long inboundtime;

    /**
     * 生产时间
     */
    private Long producttime;

    /**
     * 质检状态
     */
    private Integer qcstatus;

    /**
     * 箱号
     */
    private String carton;

    /**
     * 序列号
     */
    private String serialno;

    /**
     * 单据优先级[0,8]
     */
    private Integer proirity;

    /**
     * 起点位置Code
     */
    private String fromlocationcode;

    /**
     * 起点位置ID
     */
    private Long fromlocationid;

    /**
     * 组织（客户，供应商）
     */
    private Long organiztionid;

    /**
     * 
     */
    private String shipaccordingtoordercode;

    /**
     * 终点位置Code
     */
    private String toloccode;

    /**
     * 终点位置ID
     */
    private Long tolocid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}