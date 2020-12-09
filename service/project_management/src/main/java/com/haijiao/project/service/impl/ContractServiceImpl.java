package com.haijiao.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haijiao.project.client.FileClient;
import com.haijiao.project.entity.Contract;
import com.haijiao.project.entity.ContractFile;
import com.haijiao.project.entity.vo.ContractQuery;
import com.haijiao.project.mapper.ContractFileMapper;
import com.haijiao.project.mapper.ContractMapper;
import com.haijiao.project.service.ContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hy
 * @since 2020-10-25
 */
@Service
@Slf4j
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private ContractFileMapper contractFileMapper;






    /**
     * 新增委托单
     * @param contract
     * @return
     */


     @Override
     @Transactional
     public Contract saveAll(Contract contract) {

         //------第一步：先将委托单插入数据库------
         contractMapper.insert(contract);
         Integer contractId=contract.getId();

         for (ContractFile contractFile:contract.getContractFiles()) {
             contractFile.setContractId(contractId);
                 contractFileMapper.insert(contractFile);
             }

         return contract;

     }





    /**
     * 分页条件查询委托单的方法
     */


    @Override
    public void pageQuery(Page<Contract> pageParam, ContractQuery contractQuery) {

        // 构建条件
        QueryWrapper<Contract> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByAsc("gmt_create");
        queryWrapper.orderByDesc("gmt_modified");

        // 多条件组合查询
        //mybatis学过 动态sql
        // 判断条件是否为空 如果不为空拼接条件
        if (contractQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String projectCategory = contractQuery.getProjectCategory();//项目类型
        String initiator = contractQuery.getInitiator();//发起人
        String client = contractQuery.getClientRepresentative();//客户名称
        String acceptedId = contractQuery.getAcceptedId();//受理编号
        String projectName = contractQuery.getProjectName();//工程名称
        String detectionLocation = contractQuery.getDetectionLocation();//检测地点


        if (!StringUtils.isEmpty(initiator)) {
            queryWrapper.like("initiator", initiator);
        }

        if (!StringUtils.isEmpty(client)) {
            queryWrapper.like("client_representative", client);
        }

        if (!StringUtils.isEmpty(acceptedId)) {
            queryWrapper.like("accepted_id", acceptedId);
        }

        if (!StringUtils.isEmpty(projectName)) {
            queryWrapper.like("project_name", projectName);
        }

        if (!StringUtils.isEmpty(detectionLocation)) {
            queryWrapper.like("detection_location", detectionLocation);
        }

        if (projectCategory!=null) {
            // 构建条件
            queryWrapper.eq("project_category", projectCategory);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }





    /**
     * 查询所有审核中委托单列表
     * @return
     */


     @Override
     public List<Contract> findAllReviewing() {
     // 构建条件
     QueryWrapper<Contract> queryWrapper = new QueryWrapper<>();
     queryWrapper.eq("review_status",1);

     return contractMapper.selectList(queryWrapper);

     }



     /**
      * 查询所有审核过的委托单列表
     */

     @Override
     public List<Contract> findAllReviewed() {
     // 构建条件
     QueryWrapper<Contract> queryWrapper = new QueryWrapper<>();
     queryWrapper.ne("review_status",1);

      return contractMapper.selectList(queryWrapper);

     }


    /**
     * 根据委托单id审核委托单
     */

    @Override
    public Contract auditContractById(Integer contractId, Integer auditorId, Integer opinion, String comment) {

        Contract contract = contractMapper.selectById(contractId);
        Map<String, Integer> opinions = contract.getOpinions();
        opinions.put(auditorId.toString(), opinion);

        Map<String, String> comments = contract.getComments();

        //如果第一个人审核，评论为空，需要初始化
        if (comments == null) {
            comments = new HashMap<>();
        }

        comments.put(auditorId.toString(), comment);
        contract.setOpinions(opinions)    //保存审核意见
                .setComments(comments); //保存审核评论

        contractMapper.updateById(contract);
        return contract;

    }
}
