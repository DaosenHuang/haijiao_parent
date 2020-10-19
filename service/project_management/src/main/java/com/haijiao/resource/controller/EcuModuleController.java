package com.haijiao.resource.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haijiao.Result;
import com.haijiao.resource.entity.EcuModule;
import com.haijiao.resource.entity.vo.EcuModuleQuery;
import com.haijiao.resource.service.EcuModuleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-10-03
 */
@RestController
@RequestMapping("/module-service/ecu-module")
public class EcuModuleController {

    //注入service
    @Autowired
    private EcuModuleService ecuModuleService;

    //查询员工表所有数据
    //rest风格
    @ApiOperation(value="所有模块列表")  //swagger提供的注解
    @GetMapping("findAll")
    public Result findAllEcuModule(){
        //调用service方法来查询所有的操作
        List<EcuModule> list=ecuModuleService.list(null);
        //链式操作
        return Result.ok().data("数据",list);
    }

    //删除模块方法
    @ApiOperation(value="逻辑删除模块")
    @DeleteMapping("{id}")
    public Result removeEcuModule(@ApiParam(name="id",value="模块id",required=true) @PathVariable Integer id){
        boolean flag=ecuModuleService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }



    //添加模块方法
    @PostMapping("addEcuModule")
    @ApiOperation(value="添加模块")
    public Result addEcuModule(@RequestBody EcuModule ecuModule) {
        boolean save = ecuModuleService.save(ecuModule);
        if (save) {
            return Result.ok();
        }
        else{
            return Result.error();
        }
    }

    //3 分页查询员工的方法
    //current 当前页
    //limit 每页记录数
    @ApiOperation(value="分页查询")
    @GetMapping("pageEmployee/{current}/{limit}")
    public Result pageListEcuModule(@PathVariable long current,
                                   @PathVariable long limit){
        //创建page对象
        Page<EcuModule> pageEcuModule = new Page<>(current, limit);


        //调用方法实现分页
        //调用方法的时候，底层封装，把分页所有数据封装到pageEmployee对象里面
        ecuModuleService.page(pageEcuModule,null);
        long total = pageEcuModule.getTotal(); // 总的记录数
        List<EcuModule> records = pageEcuModule.getRecords(); //获取list集合

        return Result.ok().data("rows", records);
    }

    //多条件组合查询带分页
    @PostMapping("pageEcuModuleCondition/{current}/{limit}")
    @ApiOperation(value="条件分页查询")
    public Result pageEcuModuleCondition(@PathVariable long current,@PathVariable long limit,
                                        @RequestBody(required = false) EcuModuleQuery ecuModuleQuery) {
        //创建page对象
        Page<EcuModule> pageEcuModule = new Page<>(current, limit);
        //调用方法实现条件查询分页
        //构建条件
        QueryWrapper<EcuModule> wrapper = new QueryWrapper<>();
        //mybatis动态sql
        //判断条件是否为空，如果不为空拼接条件
        String name = ecuModuleQuery.getEcuName();
        String num = ecuModuleQuery.getEcuNum();
        String type = ecuModuleQuery.getEcuType();

        if (!StringUtils.isEmpty(name)) {
            //构建条件
            wrapper.like("ecu_name", name);
        }
        if (!StringUtils.isEmpty(num)) {
            wrapper.eq("ecu_num", num);
        }
        if (!StringUtils.isEmpty(type)) {
            //构建条件
            wrapper.eq("ecu_type", type);
        }
        //wrapper
        ecuModuleService.page(pageEcuModule, wrapper);
        long total = pageEcuModule.getTotal();//总记录数
        List<EcuModule> records = pageEcuModule.getRecords(); //数据list集合
        return Result.ok().data("total", total).data("rows", records);
    }

    //修改员工功能
    @ApiOperation(value="修改模块")
    @PostMapping("updateEcuModule")
    public Result updateEcuModule(@RequestBody EcuModule module){
        boolean flag = ecuModuleService.updateById(module);
        if(flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    //根据员工ID查询
    @ApiOperation(value="根据模块id查询")
    @GetMapping("searchEcuModule/{id}")
    public Result searchEcuModule(@PathVariable Integer id){
        EcuModule ecuModule = ecuModuleService.getById(id);
        return Result.ok().data("ecuModule",ecuModule);
    }
}

