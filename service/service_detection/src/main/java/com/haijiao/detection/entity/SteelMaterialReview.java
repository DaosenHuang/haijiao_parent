package com.haijiao.detection.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hy
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SteelMaterialReview对象", description="")
public class SteelMaterialReview implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "任务单编号")
    private Integer missionId;

    @ApiModelProperty(value = "安全管理员")
    private String safetyManager;

    @ApiModelProperty(value = "单位地址")
    private String companyAddress;

    @ApiModelProperty(value = "联系方式")
    private String telephone;

    @ApiModelProperty(value = "使用单位")
    private String usingCompany;

    @ApiModelProperty(value = "邮政编码")
    private String postalCode;

    @ApiModelProperty(value = "管段名称")
    private String pipelineName;

    @ApiModelProperty(value = "起始位置")
    private String startEndLocation;

    @ApiModelProperty(value = "管道区段")
    private String pipelineZone;

    @ApiModelProperty(value = "长度")
    private Float length;

    @ApiModelProperty(value = "设计单位")
    private String designCompany;

    @ApiModelProperty(value = "设计规范")
    private String designSpecification;

    @ApiModelProperty(value = "设计日期")
    private Date designData;

    @ApiModelProperty(value = "设计温度")
    private Float designTemperature;

    @ApiModelProperty(value = "设计压力")
    private Float designPresure;

    @ApiModelProperty(value = "安装及验收规范")
    private String specificationInstallCheck;

    @ApiModelProperty(value = "安装单位")
    private String installCompany;

    @ApiModelProperty(value = "竣工验收日期")
    private Date completionDate;

    @ApiModelProperty(value = "投用日期")
    private Date serviceDate;

    @ApiModelProperty(value = "实际使用年限")
    private Integer serviceYears;

    @ApiModelProperty(value = "使用压力")
    private Float operationPressure;

    @ApiModelProperty(value = "操作温度")
    private Float operationTemperature;

    @ApiModelProperty(value = "工作介质")
    private Float workingMedium;

    @ApiModelProperty(value = "管径和壁厚")
    private String diameterThickness;

    @ApiModelProperty(value = "绝热层材料")
    private String thermalMaterial;

    @ApiModelProperty(value = "管道材质")
    private String pipeTexture;

    @ApiModelProperty(value = "防腐层材料")
    private String anticrosiveMaterial;

    @ApiModelProperty(value = "绝热层厚度")
    private Float thermalThickness;

    @ApiModelProperty(value = "敷设方式")
    private String layingWay;

    @ApiModelProperty(value = "防腐层厚度")
    private Float anticrosiveThickness;

    @ApiModelProperty(value = "上次报告编号")
    private String lasttimeReportNum;

    @ApiModelProperty(value = "阴极保护方式")
    private String cathodicProtectionMode;

    @ApiModelProperty(value = "上次检验日期")
    private Date lasttimeSurveyDate;

    @ApiModelProperty(value = "资料审查问题记载")
    private String problemRecord;

    @ApiModelProperty(value = "上次检验问题记载")
    private String lasttimeProblems;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtModified;

    //-------包含的文件-------------
    @ApiModelProperty(value="包含的文件")
    @TableField(exist=false)
    private List<SteelMaterialReviewFile> files;


}
