package com.haijiao.project.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EcustProject对象", description="根据任务单生成的工程")
public class EcustProject {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="任务单ID")
    private Integer missionId;

    @ApiModelProperty(value = "工程名称")
    private String projectName;

    @ApiModelProperty(value = "工程负责人")
    private String projectChargeMan;

    @ApiModelProperty(value = "工程总体进度")
    private Float schedule;

    @ApiModelProperty(value = "项目状态")
    private Integer projectStatus;

    @ApiModelProperty(value = "开工日期")
    private Date startTime;

    @ApiModelProperty(value = "要求完工日期")
    private Date requiredEndtime;

    @ApiModelProperty(value = "客户名称")
    private String clientName;

    @ApiModelProperty(value = "工程类型")
    private Integer projectType;

    @ApiModelProperty(value = "检测类型")
    private Integer detectionType;

    @ApiModelProperty(value = "创建日期")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新日期")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtModified;

}
