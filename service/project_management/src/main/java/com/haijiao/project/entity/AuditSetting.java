package com.haijiao.project.entity;

import com.alibaba.fastjson.JSON;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AuditSetting对象", description="")
public class AuditSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "审核类型")
    private String auditType;

    @ApiModelProperty(value = "审核人")
    private List<Integer> auditors;

    @ApiModelProperty(value = "创建日期")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改日期")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtUpdated;


}
