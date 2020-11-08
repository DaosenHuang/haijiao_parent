package com.haijiao.detection.service;

import com.haijiao.detection.entity.SteelMaterialReview;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hy
 * @since 2020-11-05
 */
public interface SteelMaterialReviewService extends IService<SteelMaterialReview> {

    //---新增资料审查，包括将文件也存储到数据库---
    boolean addSteelMaterialReview(SteelMaterialReview materialReview);


}
