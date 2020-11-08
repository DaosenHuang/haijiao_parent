package com.haijiao.project.entity;

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
 * 任务单表 
 * </p>
 *
 * @author hy
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Mission对象", description="任务单表 ")
public class Mission implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标识号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "委托单编号")
    private Integer contractId;

    @ApiModelProperty(value="检测类型")
    private Integer detectionType;

    @ApiModelProperty(value = "委托单位")
    private String entrustCompany;

    @ApiModelProperty(value = "检测地点")
    private String detectionLocation;

    @ApiModelProperty(value = "项目编号")
    private String projectId;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value="项目类型")
    private Integer projectCategory;

    @ApiModelProperty(value = "客户代表")
    private String clientRepresentative;

    @ApiModelProperty(value = "客户联系方式")
    private String clientTelephone;

    @ApiModelProperty(value = "业务代表")
    private String businessExecutive;

    @ApiModelProperty(value = "业务代表联系方式")
    private String businessExecutiveTelephone;

    @ApiModelProperty(value = "项目开启日期")
    private Date projectStartTime;

    @ApiModelProperty(value = "规模和特征")
    private String scaleFeature;

    @ApiModelProperty(value = "检测要求")
    private String detectionRequirement;

    @ApiModelProperty(value = "检测组长")
    private String detectionCaptain;

    @ApiModelProperty(value = "设备管理员")
    private String deviceManager;

    @ApiModelProperty(value = "其他人员")
    private String others;

    @ApiModelProperty(value = "安全员")
    private String safety;

    @ApiModelProperty(value = "项目计划节点说明")
    private String projectPlanDiscription;

    @ApiModelProperty(value = "资料审查开始时间")
    private Date materialReviewStarttime;

    @ApiModelProperty(value = "资料审查结束时间")
    private Date materialReviewEndtime;

    @ApiModelProperty(value = "现场检测开始时间")
    private Date onsiteStarttime;

    @ApiModelProperty(value = "现场检测结束时间")
    private Date onsiteEndtime;

    @ApiModelProperty(value = "开挖检测开始时间")
    private Date excavationDetectionStarttime;

    @ApiModelProperty(value = "开挖检测结束时间")
    private Date excavationDetectionEndtime;

    @ApiModelProperty(value = "报告开始时间")
    private Date reportStarttime;

    @ApiModelProperty(value = "报告结束时间")
    private Date reportEndtime;

    @ApiModelProperty(value = "包含的检测项目")
    private String detectionItems;

    @ApiModelProperty(value = "审核进度 1正在审核中；2通过；3驳回")
    private Integer reviewStatus;

//---------------属于检测工程里面显示------
    @ApiModelProperty(value="实际开工日期")
    private Date StartTime;

    @ApiModelProperty(value = "工程总体进度")
    private Float schedule;

    @ApiModelProperty(value = "要求完工日期")
    private Date requiredDate;

    @ApiModelProperty(value = "项目状态")
    private Integer projectStatus;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtModified;

    //-----与任务单相关联的员工，例如项目组长，组成员-------
    @ApiModelProperty(value = "任务单关联人员")
    @TableField(exist=false)
    private List<MissionUser> missionUserList;

    //------任务单里面分配的需要进行检测的管道集合------
    @ApiModelProperty(value = "管段集合")
    @TableField(exist=false)
    private List<MissionPipeSection> missionPipeSectionList;



}
