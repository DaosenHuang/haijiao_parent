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
 * 钢管穿越检测
 * </p>
 *
 * @author hy
 * @since 2020-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SteelCrossingDetection对象", description="钢管穿越检测")
public class SteelCrossingDetection implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "管道名称")
    private String pipelineName;

    @ApiModelProperty(value = "管道区间")
    private String pipelineInterval;

    @ApiModelProperty(value = "铺设方式")
    private String layingWay;

    @ApiModelProperty(value = "管段id")
    private Integer pipeSectionId;

    @ApiModelProperty(value = "长度")
    private Float length;

    @ApiModelProperty(value = "穿越种类")
    private String crossingType;

    @ApiModelProperty(value = "位置")
    private String location;


    @ApiModelProperty(value = "创建日期")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改日期")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtModified;


}
