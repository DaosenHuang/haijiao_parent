package com.haijiao.resource.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

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
 * @author testjava
 * @since 2020-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Employee对象", description="")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="逻辑删除：1已删除，0未删除")
    @TableLogic  //表示做逻辑删除
    private boolean isDeleted;

    @ApiModelProperty(value="员工姓名")
    private String name;

    @ApiModelProperty(value="工号")
    private String jobNumber;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="员工状态：离职：0，在职：1")
    private Integer status;

    @ApiModelProperty(value="岗位")
    private Integer post;

    @ApiModelProperty(value="所在部门")
    private Integer department;

    @ApiModelProperty(value="资质描述")
    private String qualification;

    @ApiModelProperty(value="创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value="修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
