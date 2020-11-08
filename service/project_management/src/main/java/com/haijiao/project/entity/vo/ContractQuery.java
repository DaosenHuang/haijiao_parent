package com.haijiao.project.entity.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Contract查询对象", description = "委托单查询对象封装")
@Data
public class ContractQuery {

    @ApiModelProperty(value = "发起人 默认当前用户")
    private String initiator;

    @ApiModelProperty(value = "客户代表")
    private String clientRepresentative;

    @ApiModelProperty(value = "受理编号")
    private String acceptedId;

    @ApiModelProperty(value = "检测地点")
    private String detectionLocation;

    @ApiModelProperty(value = "工程名称 文本 50 字")
    private String projectName;

    @ApiModelProperty(value = "工程类别")
    private String projectCategory;




}
