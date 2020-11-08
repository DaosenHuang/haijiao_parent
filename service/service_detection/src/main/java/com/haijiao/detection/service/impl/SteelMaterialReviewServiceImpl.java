package com.haijiao.detection.service.impl;

import com.haijiao.detection.entity.SteelMaterialReview;
import com.haijiao.detection.entity.SteelMaterialReviewFile;
import com.haijiao.detection.mapper.SteelMaterialReviewFileMapper;
import com.haijiao.detection.mapper.SteelMaterialReviewMapper;
import com.haijiao.detection.service.SteelMaterialReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hy
 * @since 2020-11-05
 */
@Service
public class SteelMaterialReviewServiceImpl extends ServiceImpl<SteelMaterialReviewMapper, SteelMaterialReview> implements SteelMaterialReviewService {

    @Autowired
    private SteelMaterialReviewMapper materialReviewMapper;
    @Autowired
    private SteelMaterialReviewFileMapper materialReviewFileMapper;

    public boolean addSteelMaterialReview(SteelMaterialReview materialReview) {
        materialReviewMapper.insert(materialReview);

        Integer materialReviewId = materialReview.getId();

        //------遍历，与任务单关联的人员保存在MissionEmployee------
        for (SteelMaterialReviewFile materialReviewFile : materialReview.getFiles()) {
            materialReviewFile.setMaterialReviewId(materialReviewId);  //设置资料审查
            materialReviewFileMapper.insert(materialReviewFile);
        }
        return true;
    }


}
