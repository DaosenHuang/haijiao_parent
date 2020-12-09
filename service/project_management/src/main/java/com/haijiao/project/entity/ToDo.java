package com.haijiao.project.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.ArrayList;
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
import org.apache.poi.ss.formula.functions.T;

/**
 * <p>
 * 
 * </p>
 *
 * @author hy
 * @since 2020-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ToDo对象", description="")
public class ToDo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "待办标题")
    private String title;

    @ApiModelProperty(value = "待办类型")
    private String todoType;

    @ApiModelProperty(value = "流程状态")
    private Integer schedule;

    @ApiModelProperty(value = "待办状态，0未处理，1已处理")
    private Integer status;

    @ApiModelProperty(value = "待办拥有者ID")
    private Integer userId;

    @ApiModelProperty(value="发起人")
    private Integer initiator;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建日期")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "变更日期")
    private Date gmtUpdated;

    //------包含的待办内容---
    @ApiModelProperty(value = "待办内容")
    private Integer toDoContent;


}
