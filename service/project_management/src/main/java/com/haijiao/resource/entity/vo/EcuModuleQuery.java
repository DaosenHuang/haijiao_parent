package com.haijiao.resource.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EcuModuleQuery {
    @ApiModelProperty(value = "模块名称， 模糊查询")
    private String ecuName;

    @ApiModelProperty(value="模块编号查询")
    private String ecuNum;

    @ApiModelProperty(value="根据类型查询")
    private Integer ecuType; //注意这里使用的的时String类型，前端穿过来的数据无需进行类型转换


}
