package com.haijiao.detection.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haijiao.detection.entity.SteelExcavationDetection;
import com.haijiao.detection.entity.SteelMaterialReview;
import com.haijiao.detection.entity.SteelMaterialReviewFile;
import com.haijiao.detection.service.SteelExcavationDetectionService;
import com.haijiao.detection.service.SteelMaterialReviewFileService;
import com.haijiao.detection.service.SteelMaterialReviewService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hy
 * @since 2020-11-05
 */
@RestController
@RequestMapping("/detection/steel-material-reviews")
public class SteelMaterialReviewController {

    @Autowired
    private SteelMaterialReviewService materialReviewService;
    @Autowired
    private SteelMaterialReviewFileService materialReviewFileService;


    //-----1、新增钢管资料审查数据------
    @ApiOperation(value = "资料审查")
    @PostMapping
    public boolean addCrossingDetection(@RequestBody SteelMaterialReview steelMaterialReview) {

        return materialReviewService.addSteelMaterialReview(steelMaterialReview);

    }

    //------- 2、根据检测工程id查询资料审查详情-----
    @ApiOperation(value = "根据任务单id查询资料审查")
    @GetMapping
    public SteelMaterialReview getByMissionId(
            @ApiParam(name = "missionId", value = "任务单ID", required = true)
            @RequestParam Integer missionId){

        //----根据管段id查询对应的检测数据------
        QueryWrapper<SteelMaterialReview> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("mission_id", missionId);
        //---先将资料审查找到---
        SteelMaterialReview steelMaterialReview=materialReviewService.getOne(queryWrapper);
        //--获取其ID---
        Integer materialReviewId=steelMaterialReview.getId();
        QueryWrapper<SteelMaterialReviewFile> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("material_review_id", materialReviewId);
//---根据资料审查id找到对应的文件---
        List<SteelMaterialReviewFile> files=materialReviewFileService.list(queryWrapper1);
        steelMaterialReview.setFiles(files);
        return steelMaterialReview;

    }


}

