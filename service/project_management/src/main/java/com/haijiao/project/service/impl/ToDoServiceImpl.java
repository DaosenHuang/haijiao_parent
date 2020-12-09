package com.haijiao.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haijiao.project.entity.AuditSetting;
import com.haijiao.project.entity.Contract;
import com.haijiao.project.entity.ToDo;
import com.haijiao.project.mapper.ContractMapper;
import com.haijiao.project.mapper.ToDoMapper;
import com.haijiao.project.service.AuditSettingService;
import com.haijiao.project.service.ToDoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hy
 * @since 2020-11-25
 */
@Service
public class ToDoServiceImpl extends ServiceImpl<ToDoMapper, ToDo> implements ToDoService {

    @Autowired
    private ToDoMapper toDoMapper;

    @Autowired
    private AuditSettingService auditSettingService;

    @Autowired
    private ContractMapper contractMapper;

    /**
     * 提交委托单，两个子任务：
     * 1、为审核人生成待办
     * 2、查询委托单设置获得审核人id，将委托单的opinions初始化
     * @param contractId
     * @param initiatorId
     * @return
     */
    public List<ToDo> submitContractToDo(Integer contractId, Integer initiatorId) {

        AuditSetting contractAuditSetting=auditSettingService.searchByAuditType("CONTRACT_AUDIT");
        List<Integer> auditorIds=contractAuditSetting.getAuditors(); //得到审核人名单

        Map<String, Integer> opinions=new HashMap<>(); // 用来保存审核人的审核意见

        List<ToDo> todos = new ArrayList<>(); //生成的待办id集合

        for (Integer id:auditorIds) {

            opinions.put(id.toString(), 0 );  //0表示审核人暂未审核

            ToDo contractTodo = new ToDo();
            contractTodo.setTitle("委托单审核")  //设置待办标题为委托单审核
                    .setTodoType("CONTRACT_AUDIT") //待办类型
                    .setToDoContent(contractId)  //待办内容为委托单
                    .setInitiator(initiatorId)  //设置发起人
                    .setUserId(id);  //审核人的id
            toDoMapper.insert(contractTodo);
            todos.add(contractTodo);
        }

        //同时将委托单的审核人意见做修改
        Contract contract = new Contract();
        contract.setId(contractId)
                .setOpinions(opinions);
        contractMapper.updateById(contract);

        return todos;  //返回生成的todo集合

    }

    //根据组合条件查询待办事项
    public List<ToDo> searchMyToDo(Integer userId, Integer status) {

        QueryWrapper<ToDo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("status", status);

        return toDoMapper.selectList(queryWrapper);
    }

    //根据发起人id查询待办
    public List<ToDo> searchToDoByMe(Integer initiatorId) {
        QueryWrapper<ToDo> toDoQueryWrapper=new QueryWrapper<>();
        toDoQueryWrapper.eq("initiator", initiatorId);

        return toDoMapper.selectList(toDoQueryWrapper);

    }
}
