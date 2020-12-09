package com.haijiao.project.service.impl;

import com.haijiao.project.entity.Mission;
import com.haijiao.project.entity.MissionPipeSection;
import com.haijiao.project.entity.MissionUser;
import com.haijiao.project.mapper.MissionMapper;
import com.haijiao.project.mapper.MissionPipeSectionMapper;
import com.haijiao.project.mapper.MissionUserMapper;
import com.haijiao.project.service.MissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 任务单表  服务实现类
 * </p>
 *
 * @author hy
 * @since 2020-10-26
 */
@Service
public class MissionServiceImpl extends ServiceImpl<MissionMapper, Mission> implements MissionService {

    @Autowired
    private MissionMapper missionMapper;

    @Autowired
    private MissionUserMapper missionUserMapper;

    @Autowired
    private MissionPipeSectionMapper missionPipeSectionMapper;


    //---添加任务单，并保存与之关联的管段、人员信息----
    public boolean addMission(Mission mission) {

        missionMapper.insert(mission);
        Integer missionId=mission.getId();

        //------遍历，与任务单关联的人员保存在MissionEmployee------
        for (MissionUser missionUser : mission.getMissionUserList()) {
            missionUser.setMissionId(missionId);  //设置missionId
            missionUserMapper.insert(missionUser);
        }

        //------与任务单关联的管段保存在MissionPipeSection------
        for (MissionPipeSection missionPipeSection:mission.getMissionPipeSectionList()) {
            missionPipeSection.setMissionId(missionId);
            missionPipeSectionMapper.insert(missionPipeSection);
        }
        return true;
    }





}
