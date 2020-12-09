package com.haijiao.project.service;

import com.haijiao.project.entity.ContractFile;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 附件 服务类
 * </p>
 *
 * @author hy
 * @since 2020-10-25
 */
public interface ContractFileService extends IService<ContractFile> {

    //-------根据委托单ID查询对应的文件ID------
    List<ContractFile> getContractFileByContractId(Integer contractId);



}
