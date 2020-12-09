package com.haijiao.project.controller;


import com.haijiao.project.entity.AuditSetting;
import com.haijiao.project.entity.ToDo;
import com.haijiao.project.service.ContractService;
import com.haijiao.project.service.ToDoService;
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
 * @since 2020-11-25
 */
@RestController
@RequestMapping("/project/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;


    @GetMapping("my-todo")
    @ApiOperation(value="根据组合条件查询待办事项，我的待办、已办")
    public List<ToDo> searchMyToDo(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam Integer userId,

            @ApiParam(name = "status", value = "待办状态", required = true)
            @RequestParam Integer status) {

        return toDoService.searchMyToDo(userId,status);

    }

    @PostMapping
    @ApiOperation(value="根据委托单id增加委托单审核待办事项")
    public List<ToDo> submitContract(
            @ApiParam(name = "contractId", value = "委托单", required = true)
            @RequestParam Integer contractId,

            @ApiParam(name = "initiatorId", value = "发起人", required = true)
            @RequestParam Integer initiatorId) {

            return   toDoService.submitContractToDo(contractId,initiatorId);

    }

    @GetMapping("sponsoredByMe")
    @ApiOperation(value="我发起的待办")
    public List<ToDo> searchToDoByMe(
            @ApiParam(name = "initiatorId", value = "发起人id", required = true)
            @RequestParam Integer initiatorId) {

        return toDoService.searchToDoByMe(initiatorId);

    }

}

