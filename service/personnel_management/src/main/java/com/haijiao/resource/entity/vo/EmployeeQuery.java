package com.haijiao.resource.entity.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EmployeeQuery {
    @ApiModelProperty(value = "员工名称， 模糊查询")
    private String name;

    @ApiModelProperty(value="工号查询")
    private String jobNumber;

    @ApiModelProperty(value="根据部门查询")
    private Integer department; //注意这里使用的的时String类型，前端穿过来的数据无需进行类型转换

    @ApiModelProperty(value = "根据岗位查询员工")
    private Integer post;


}
