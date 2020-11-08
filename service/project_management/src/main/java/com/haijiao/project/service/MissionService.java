package com.haijiao.project.service;

import com.haijiao.project.entity.Mission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 任务单表  服务类
 * </p>
 *
 * @author hy
 * @since 2020-10-26
 */
public interface MissionService extends IService<Mission> {
    //------1、新增任务单------
    boolean addMission(Mission mission);






}
