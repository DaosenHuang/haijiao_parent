package com.haijiao.resource.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haijiao.Result;
import com.haijiao.resource.entity.Employee;
import com.haijiao.resource.service.EmployeeService;
import io.swagger.annotations.ApiModelProperty;
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
 * @author testjava
 * @since 2020-08-31
 */
@RestController
@RequestMapping("/resource/employee")
public class EmployeeController {
    //注入service
    @Autowired
    private EmployeeService employeeService;

    //查询员工表所有数据
    //rest风格
    @ApiOperation(value="所有员工列表")  //swagger提供的注解
    @GetMapping("findAll")
    public Result findAllEmployee(){
        //调用service方法来查询所有的操作
        List<Employee> list=employeeService.list(null);
        //链式操作
        return Result.ok().data("数据",list);
    }

    //删除员工方法
    @ApiOperation(value="逻辑删除员工")
    @DeleteMapping("{id}")
    public Result removeEmployee(@ApiParam(name="id",value="员工id",required=true) @PathVariable String id){
        boolean flag=employeeService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    //3 分页查询员工的方法
    //current 当前页
    //limit 每页记录数
    @ApiOperation(value="分页查询")
    @GetMapping("pageEmployee/{current}/{limit}")
    public Result pageListEmployee(@PathVariable long current,
                                   @PathVariable long limit){
       //创建page对象
        Page<Employee> pageEmployee = new Page<>(1,3);

        //调用方法实现分页
        //调用方法的时候，底层封装，把分页所有数据封装到pageEmployee对象里面
        employeeService.page(pageEmployee,null);
        long total = pageEmployee.getTotal();
        List<Employee> records = pageEmployee.getRecords(); //获取list集合

        return Result.ok().data("rows",records);
    }

    //添加员工方法
    @PostMapping("addEmployee")
    @ApiOperation(value="添加员工")
    public Result addEmployee(@RequestBody Employee employee) {
        boolean save = employeeService.save(employee);
        if (save) {
            return Result.ok();
        }
        else{
            return Result.error();
        }
    }

    //根据员工ID查询
    @ApiOperation(value="根据员工id查询")
    @GetMapping("searchEmployee/{id}")
    public Result searchEmployee(@PathVariable String id){
        Employee employee = employeeService.getById(id);
        return Result.ok().data("employee",employee);
    }

    //修改员工功能
    @PostMapping("updateEmployee")
    public Result updateEmployee(@RequestBody Employee employee){
        boolean flag = employeeService.updateById(employee);
        if(flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }
}

