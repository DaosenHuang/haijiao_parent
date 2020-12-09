package com.haijiao.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haijiao.project.entity.ContractFile;
import com.haijiao.project.mapper.ContractFileMapper;
import com.haijiao.project.service.ContractFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 附件 服务实现类
 * </p>
 *
 * @author hy
 * @since 2020-10-25
 */
@Service
public class ContractFileServiceImpl extends ServiceImpl<ContractFileMapper, ContractFile> implements ContractFileService {

    @Autowired
    private ContractFileMapper contractFileMapper;

    //-------根据委托单编号查找与其对应的文件Id-------
    public List<ContractFile> getContractFileByContractId(Integer contractId) {

        //-------构造条件-------
        QueryWrapper<ContractFile> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("contract_id", contractId);

        return contractFileMapper.selectList(queryWrapper);



    }

}
