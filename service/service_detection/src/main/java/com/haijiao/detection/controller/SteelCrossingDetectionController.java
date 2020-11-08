package com.haijiao.detection.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haijiao.detection.entity.SteelCrossingDetection;
import com.haijiao.detection.service.SteelCrossingDetectionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 钢管穿越检测 前端控制器
 * </p>
 *
 * @author hy
 * @since 2020-11-04
 */
@RestController
@RequestMapping("/detection/steel-crossing-detections")
public class SteelCrossingDetectionController {

    @Autowired
    private SteelCrossingDetectionService crossingDetectionService;

    //新增钢管穿越检测数据
    @ApiOperation(value = "新增钢管穿越检测数据")
    @PostMapping()
    public boolean addCrossingDetection(@RequestBody SteelCrossingDetection steelCrossingDetection) {

        return crossingDetectionService.save(steelCrossingDetection);

    }

    //------- 4、根据管段id查询检测数据-----
    @ApiOperation(value = "根据管段id查询穿越检测数据")
    @GetMapping
    public SteelCrossingDetection getByPipeSectionId(
            @ApiParam(name = "pipeSectionId", value = "管段ID", required = true)
            @RequestParam Integer pipeSectionId){

//----根据管段id查询对应的检测数据------
        QueryWrapper<SteelCrossingDetection> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("pipe_section_id", pipeSectionId);

        return crossingDetectionService.getOne(queryWrapper);

    }






}

