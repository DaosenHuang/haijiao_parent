package com.haijiao.project.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haijiao.project.entity.Contract;
import com.baomidou.mybatisplus.extension.service.IService;
import com.haijiao.project.entity.ContractFile;
import com.haijiao.project.entity.vo.ContractQuery;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hy
 * @since 2020-10-25
 */
public interface ContractService extends IService<Contract> {





    //-------保存委托单，和与之相关联的附件、审核人评论------
    Contract saveAll(Contract contract);


    //------- 条件分页查询委托单列表-----
    void pageQuery(Page<Contract> pageParam, ContractQuery contractQuery);


    //--------查询所有正在审核的委托单------
    List<Contract> findAllReviewing();


    //------查询所有审核通过的委托单-------
    List<Contract> findAllReviewed();

    //------根据委托单id审核委托单------
    Contract auditContractById(Integer contractId, Integer opinion, Integer auditorId, String comment);




}
