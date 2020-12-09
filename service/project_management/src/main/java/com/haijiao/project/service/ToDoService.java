package com.haijiao.project.service;

import com.haijiao.project.entity.Contract;
import com.haijiao.project.entity.ToDo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.haijiao.project.mapper.ToDoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hy
 * @since 2020-11-25
 */
public interface ToDoService extends IService<ToDo> {

    //---根据委托单id新增委托单审核待办通知---
    List<ToDo> submitContractToDo(Integer contractId, Integer initiatorId);

    //---根据用户id查询用户的待办事项---
     List<ToDo> searchMyToDo(Integer userId, Integer status);

     //---根据发起人的id查询待办--
    List<ToDo> searchToDoByMe(Integer initiatorId);
}
