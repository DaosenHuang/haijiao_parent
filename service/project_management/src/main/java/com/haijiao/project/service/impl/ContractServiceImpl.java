package com.haijiao.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haijiao.project.entity.Contract;
import com.haijiao.project.entity.ContractComment;
import com.haijiao.project.entity.ContractFile;
import com.haijiao.project.entity.File;
import com.haijiao.project.entity.vo.ContractQuery;
import com.haijiao.project.mapper.ContractCommentMapper;
import com.haijiao.project.mapper.ContractFileMapper;
import com.haijiao.project.mapper.ContractMapper;
import com.haijiao.project.mapper.FileMapper;
import com.haijiao.project.service.ContractCommentService;
import com.haijiao.project.service.ContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haijiao.project.service.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hy
 * @since 2020-10-25
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private ContractFileMapper contractFileMapper;

    @Autowired
    private FileMapper fileMapper;



    /**
     * 新增委托单
     * @param contract
     * @return
     */


     @Override
     @Transactional
     public boolean saveAll(Contract contract) {


         //  BeanUtils.copyProperties(contract);
         //        通过插入的封装的对象，调用mabatis plus的insert的方法插入一条数据到数据库，
         //        然后通过对象的get方法拿到插入数据的id

         //------第一步：先将委托单插入数据库------
         contractMapper.insert(contract);
         Integer contractId = contract.getId(); //获取委托单id
         //------第二部：获取与委托单关联的文件------
         for (File file : contract.getFiles()) {
             //先保存文件，得到id
             fileMapper.insert(file);
         }

         QueryWrapper<File> queryWrapper=new QueryWrapper<>();
         queryWrapper.eq("contract_id", contractId);

         List<File> files = fileMapper.selectList(queryWrapper);

         for (File file:files) {

             Integer fileId = file.getId();       // 获取文件id
             String fileType = file.getType();    // 获取文件类型

             ContractFile contractFile = new ContractFile();
             contractFile.setContractId(contractId);
             contractFile.setFileId(fileId);
             contractFile.setType(fileType);
             //------保存中间表------
             contractFileMapper.insert(contractFile);

         }
         return true;
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

/**
     //-------对查询到的委托单进行遍历，依次查出与之关联的文件-------
     for (Contract contract:contractList) {
         Integer contractId = contract.getId();  //---第一步：获取委托单ID------
         QueryWrapper<ContractFile> queryWrapper1 = new QueryWrapper<>(); //----构建条件----
         queryWrapper1.eq("contractId", contractId); //---第二步： 根据委托单ID查找contractFile中间表----

         List<File> fileList = new ArrayList<>(); //--- 列表用来存储查询到的与委托单相关联的文件-----
          for (ContractFile contractFile: contractFileMapper.selectList(queryWrapper1)) {
              Integer fileId = contractFile.getFileId();
              fileList.add(fileService.getById(fileId));
          }

          contract.setFiles(fileList); //----第三步： 将查询到的文件列表封装到contract对象-----

     }
*/

     }



     /**
      * 查询所有审核过的委托单列表
      * @return
     */

     @Override
     public List<Contract> findAllReviewed() {
     // 构建条件
     QueryWrapper<Contract> queryWrapper = new QueryWrapper<>();
     queryWrapper.ne("review_status",1);

      return contractMapper.selectList(queryWrapper);

      /**
         //-------对查询到的委托单进行遍历，依次查出与之关联的文件-------
         for (Contract contractReviewed:contractReviewedList) {
             Integer contractId = contractReviewed.getId();  //---第一步：获取委托单ID------

             //------第二步：构建条件------
             QueryWrapper<ContractFile> queryWrapper1 = new QueryWrapper<>(); //----构建查询contractFile条件----
             queryWrapper1.eq("contractId", contractId);

             QueryWrapper<ContractComment> queryForComment = new QueryWrapper<>(); //构建查询contractComment条件----
             queryForComment.eq("contractId", contractId);

             // ---将查询到的与委托单关联的评论封装在contract对象---
             List<ContractComment> contractComments = new ArrayList<>();
             for (ContractComment contractComment:contractCommentMapper.selectList(queryForComment)){
                 contractComments.add(contractComment);
             }
             contractReviewed.setContractComments(contractComments);


             List<File> fileList = new ArrayList<>(); //--- 列表用来存储查询到的与委托单相关联的文件-----
             for (ContractFile contractFile: contractFileMapper.selectList(queryWrapper1)) {
                 Integer fileId = contractFile.getFileId();
                 fileList.add(fileService.getById(fileId));
             }
             contractReviewed.setFiles(fileList); //----第三步： 将查询到的文件列表封装到contract对象-----
         }
        */

     }
}
