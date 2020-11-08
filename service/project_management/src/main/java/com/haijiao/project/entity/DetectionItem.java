package com.haijiao.project.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DetectionItem {

    @ApiModelProperty(value="是否是钢管检测")
    private boolean isSteel;

    @ApiModelProperty(value="是否是钢管检测")
    private boolean isPe;

    private boolean steelMaterialReview=true;

    private boolean SteelCrossingDetection;

    private boolean SteelExcavationDetection;

}
