package com.haijiao.project.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.JsonObject;


import com.haijiao.project.entity.Mission;
import com.haijiao.project.entity.MissionPipeSection;
import com.haijiao.project.entity.MissionUser;
import com.haijiao.project.service.MissionPipeSectionService;
import com.haijiao.project.service.MissionService;
import com.haijiao.project.service.MissionUserService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务单表  前端控制器
 * </p>
 *
 * @author hy
 * @since 2020-10-26
 */
@RestController
@RequestMapping("/project/missions")
public class MissionController {

    @Autowired
    private MissionService missionService;
    @Autowired
    private MissionPipeSectionService missionPipeSectionService;
    @Autowired
    private MissionUserService missionUserService;



    // ----1、新增任务单,保存与其相关联的人员，管段------
    @ApiOperation(value = "新增任务单")
    @PostMapping
    public String addMission(
            @ApiParam(name = "mission", value = "任务单对象", required = true)
            @RequestBody Mission mission){

       boolean flag =  missionService.addMission(mission);
       if (flag) {
           return "任务单提交成功！";
       }
       else {
           return "添加失败！";
       }

    }


    //--------2、根据状态分页查询任务单-------------
    @ApiOperation(value = "根据审核状态查询任务单,1正在审核，2审核通过，3被驳回")
    @GetMapping("pageMissions")
    public Map<String, Object> pageMissionByReviewStatus(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @RequestParam Integer page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @RequestParam Integer limit,

            @ApiParam(name = "reviewStatus", value = "任务单审核状态", required = true)
            @RequestParam Integer reviewStatus)
    {

        Page<Mission> pageParam = new Page<>(page, limit);
        QueryWrapper<Mission> queryWrapper = new QueryWrapper<>();


        queryWrapper.eq("review_status",reviewStatus);
        queryWrapper.orderByDesc("gmt_modified");
        missionService.page(pageParam, queryWrapper);
        List<Mission> missionList = pageParam.getRecords();

        Long total = pageParam.getTotal();

        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("总记录数", total);
        stringObjectHashMap.put("任务单集合", missionList);

        return  stringObjectHashMap;

    }






    //------- 3、根据任务单id查询任务单详情-----
    @ApiOperation(value = "根据任务单id查询任务单详情")
    @GetMapping("details")
    public Mission getById(
            @ApiParam(name = "missionId", value = "任务单ID", required = true)
            @RequestParam Integer missionId){
        Mission mission = missionService.getById(missionId);

        //--设置条件--
        QueryWrapper<MissionPipeSection> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("mission_id", missionId);
        QueryWrapper<MissionUser> queryWrapper2=new QueryWrapper<>();
        queryWrapper2.eq("mission_id", missionId);

        //--封装到misson对象---
        mission.setMissionPipeSectionList(missionPipeSectionService.list(queryWrapper1));
        mission.setMissionUserList(missionUserService.list(queryWrapper2));

        return mission;
    }



//-----4、修改任务单审核状态------
    @ApiOperation(value = "根据任务单ID修改审核状态")
    @PutMapping
    public String updateMission(
            @ApiParam(name = "id", value = "任务单ID", required = true)
            @RequestParam Integer id,
            @ApiParam(name = "reviewStatus", value = "审核", required = true)
            @RequestParam Integer reviewStatus){

        Mission mission = new Mission();
        mission.setId(id);
        mission.setReviewStatus(reviewStatus);

        boolean flag =  missionService.updateById(mission);
        if (flag) {
            return "审核状态修改成功！";
        }
        else {
            return "修改失败！";
        }

        /**
        boolean flag = missionService.updateById(mission);
        Mission missionUpdated = missionService.getById(id);

        String projectName=missionUpdated.getProjectName(); //工程名称
        String projectChargeMan=missionUpdated.getDetectionCaptain(); //工程负责人
        String clientName = missionUpdated.getEntrustCompany(); // 客户名称（委托单位）
        Integer projectCategory=missionUpdated.getProjectCategory(); // 项目类型
        Integer detectionType=missionUpdated.getDetectionType();  //检测类型

        //------属性值绑定------
        EcustProject ecustProject = new EcustProject();
        ecustProject.setMissionId(id);
        ecustProject.setClientName(clientName);
        ecustProject.setProjectChargeMan(projectChargeMan);
        ecustProject.setProjectName(projectName);
        ecustProject.setProjectType(projectCategory);
        ecustProject.setDetectionType(detectionType);
        */

    }





    //-----5、根据id删除任务单表中数据-----
    @ApiOperation(value = "根据id删除任务单")
    @DeleteMapping
//    //@PreAuthorize("hasAuthority('order:delete')")
    public boolean removeById(
            @ApiParam(name = "id", value = "任务单ID", required = true)
            @RequestParam Integer id){

        return missionService.removeById(id);

    }


    //-------6、根据项目状态展示项目表单------

    @ApiOperation(value = "根据项目状态查询任务单,0正在进行的项目，1已结束")
    @GetMapping("projects")
    public Map<String,Object> pageMissionByProjectStatus(
            @ApiParam(name = "page",value = "当前页码", required = true)
            @RequestParam Integer page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @RequestParam Integer limit,

            @ApiParam(name = "projectStatus", value = "项目状态", required = true)
            @RequestParam Integer projectStatus) {

        Page<Mission> pageParam = new Page<>(page, limit);
        QueryWrapper<Mission> queryWrapper = new QueryWrapper<>();


        queryWrapper.eq("project_status",projectStatus);

        queryWrapper.orderByDesc("gmt_modified");
        missionService.page(pageParam, queryWrapper);
        List<Mission> missionList = pageParam.getRecords();

        Long total = pageParam.getTotal();

        Map<String, Object> result = new HashMap<>();
        result.put("总记录数", total);
        result.put("项目集合", missionList);

        return result;
    }

}

