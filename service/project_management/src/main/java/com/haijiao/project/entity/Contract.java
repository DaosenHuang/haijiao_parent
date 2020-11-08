package com.haijiao.project.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author hy
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Contract对象", description="")
public class Contract implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "发起人")
    private String initiator;

    @ApiModelProperty(value = "受理日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date acceptedDate;

    @ApiModelProperty(value = "受理编号")
    private String acceptedId;

    @ApiModelProperty(value = "检测地点")
    private String detectionLocation;

    @ApiModelProperty(value = "工程名称")
    private String projectName;

    @ApiModelProperty(value = "客户名称（委托单位）")
    private String clientName;

    @ApiModelProperty(value = "客户代表")
    private String clientRepresentative;

    @ApiModelProperty(value = "单位电话")
    private String companyPhoneNumber;

    @ApiModelProperty(value = "手机")
    private String telephone;

    @ApiModelProperty(value = "要求检测日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date requiredDate;

    @ApiModelProperty(value = "项目类别")
    private Integer projectCategory;

    @ApiModelProperty(value = "工程类别")
    private Integer engineerCategory;

    @ApiModelProperty(value = "规格")
    private String specification;

    @ApiModelProperty(value = "要进行的检测项目，多选RT，UT，MT，PT，ET，测厚，理化检验，设备性能检验分别对应（1，2，3，4，5，6，7，8），")
    private String testItems;

    @ApiModelProperty(value = "设备性能检验检测技术要求")
    private String technicalRequirement;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtModified;

    @ApiModelProperty(value = "审核状态 ， 1正在审核； 2通过审核；3被驳回")
    private Integer reviewStatus;


    @TableLogic  //表示做逻辑删除
    @ApiModelProperty(value="未删除：0，已删除：1")
    private Integer isDeleted;


    //------附件------
    @ApiModelProperty(value = "委托单-附件")
    @TableField(exist=false)
    private List<File> files;


    //-------委托单_附件------
    @ApiModelProperty(value = "委托单-附件")
    @TableField(exist=false)
    private List<ContractFile> contractFiles;

    //-------评论------
    @ApiModelProperty(value = "审核人评论")
    @TableField(exist=false)
    private List<ContractComment> contractComments;


}
