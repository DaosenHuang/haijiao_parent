package com.haijiao.project.entity;

import com.alibaba.fastjson.JSON;


import java.util.Date;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import springfox.documentation.spring.web.json.Json;

/**
 * <p>
 * 
 * </p>
 *
 * @author hy
 * @since 2020-11-26
 */
@Data
@TableName(autoResultMap = true)
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AuditSetting对象", description="设置审核人")
public class AuditSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value="名称")
    private String name;

    @ApiModelProperty(value = "审核类型")
    private String auditType;

    @ApiModelProperty(value = "审核人")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Integer> auditors;

    @ApiModelProperty(value = "创建日期")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改日期")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtModified;


}
