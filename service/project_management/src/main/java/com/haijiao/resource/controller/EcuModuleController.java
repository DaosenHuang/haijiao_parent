package com.haijiao.resource.controller;


import com.haijiao.Result;
import com.haijiao.resource.entity.EcuModule;
import com.haijiao.resource.service.EcuModuleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-09-27
 */
@RestController
@RequestMapping("/resource/module")
public class EcuModuleController {

    //注入服务
    @Autowired
    private EcuModuleService ecuModuleService;

    //查询员工表所有数据
    //rest风格
    @ApiOperation(value="所有模块列表")  //swagger提供的注解
    @GetMapping("findAll")
    public Result findAllModule(){
        //调用service方法来查询所有的操作
        List<EcuModule> list=ecuModuleService.list(null);
        //链式操作
        return Result.ok().data("数据",list);
    }


}

