package com.haijiao.detection.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 钢管开挖检测
 * </p>
 *
 * @author hy
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SteelExcavationDetection对象", description="钢管开挖检测")
public class SteelExcavationDetection implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "管道名称")
    private String pipelineName;

    @ApiModelProperty(value = "管道区段")
    private String pipelineZone;

    @ApiModelProperty(value = "管道规格（mm)")
    private Float pipelineSize;

    @ApiModelProperty(value = "开挖点编号")
    private String excavationPointNum;

    @ApiModelProperty(value = "管段id")
    private Integer pipeSectionId;

    @ApiModelProperty(value = "挖坑规格")
    private String pitSize;

    @ApiModelProperty(value = "检验日期")
    private Date detectionDate;

    @ApiModelProperty(value = "检测设备名称/型号/编号")
    private String detectionDeviceNumber;

    @ApiModelProperty(value = "管道埋深")
    private Float pipelineDepth;

    @ApiModelProperty(value = "保护电位（-V）")
    private Float protectivePotential;

    @ApiModelProperty(value = "交流干扰（V）")
    private Float acDisturb;

    @ApiModelProperty(value = "地下水：0无，1有， 2时有时无")
    private Integer undergroundWater;

    @ApiModelProperty(value = "PH值")
    private Float phValue;

    @ApiModelProperty(value = "腐蚀性环境调查：地形、地貌、地物描述")
    private String landform;

    @ApiModelProperty(value = "土壤电阻率：纵向,横向")
    private String earthResistivity;



    @ApiModelProperty(value = "植物根系：1无或很少；2中等； 3茂盛")
    private Integer plantRoot;

    @ApiModelProperty(value = "土壤颜色")
    private String earthColor;

    @ApiModelProperty(value = "土壤松紧度： 1疏松； 2松； 3 稍紧； 4紧； 5 很紧")
    private Integer soilTightness;

    @ApiModelProperty(value = "土壤颗粒组划分： 1粘粒组； 2粉粒组； 3 沙粒组； 4 砾石组； 5 卵（碎）石组； 6块石")
    private Integer soilParticleDevide;

    @ApiModelProperty(value = "土壤分层描述")
    private String soilLayerDiscription;

    @ApiModelProperty(value = "土壤干湿度： 1干； 2润； 3 潮； 4湿； 5 水")
    private Integer soilHumidity;


    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtModified;


}
