package com.haijiao.project.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.haijiao.R;
import com.haijiao.project.entity.File;
import com.haijiao.project.entity.Contract;
import com.haijiao.project.entity.ContractFile;
import com.haijiao.project.entity.vo.ContractQuery;
import com.haijiao.project.service.ContractFileService;
import com.haijiao.project.service.ContractService;
import com.haijiao.project.service.FileService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hy
 * @since 2020-10-25
 */
@RestController
@RequestMapping("/project/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractFileService contractFileService;

    @Autowired
    private FileService fileService;


//---1、获取所有正在审核的委托单列表---
    @ApiOperation(value = "所有审核中委托单列表")
    @GetMapping("allReviewing")
    public List<Contract> findAllReviewing(){

         return contractService.findAllReviewing();

    }

//---2、获取所有已经被审核的委托单列表----
    @ApiOperation(value = "所有已被审核的委托单列表")
    @GetMapping("allReviewed")
    public List<Contract> findAllReviewed(){

       return contractService.findAllReviewed();

    }


//-----3、根据id删除委托单表中数据-----
    @ApiOperation(value = "根据id删除委托单")
    @DeleteMapping
//    //@PreAuthorize("hasAuthority('order:delete')")
    public boolean removeById(
            @ApiParam(name = "id", value = "委托单ID", required = true)
            @RequestParam Integer id){

            return contractService.removeById(id);

    }


    //------ 4、分页查询委托单的方法------
    @ApiOperation(value = "分页委托单列表")
    @GetMapping("pageOrder/{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit){

        Page<Contract> pageParam = new Page<>(page, limit);

        contractService.page(pageParam, null);
        List<Contract> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }

    //----5、 新增委托单------
    @ApiOperation(value = "新增委托单")
    @PostMapping
    public String addContract(
            @ApiParam(name = "contract", value = "委托单对象", required = true)
            @RequestBody Contract contract){
        boolean save = contractService.saveAll(contract);

        if (save) {
            return "恭喜你，添加委托单成功！";
        } else {
            return "很抱歉，添加失败！";
        }
    }


    //----- 6、根据委托单id查询委托单及其相关联的文件-----
    @ApiOperation(value = "根据委托单ID查询委托单")
    @GetMapping("details")
//    @PostAuthorize("hasAuthority('vip')")
    public Contract getById(
            @ApiParam(name = "id", value = "委托单ID", required = true)
            @RequestParam String id){

        Contract contract = contractService.getById(id); //--第一步--查询到委托单
        List<ContractFile> contractFiles = contractFileService.getContractFileByContractId(id);//--第二步---查询中间表获取对应的文件Id列表

        List<File> files = new ArrayList<>();  //--用来装载查询到的文件---
        //--第三步：遍历contractFile获取fileId,再查询到file------
        for (ContractFile contractFile : contractFiles) {
            Integer fileId = contractFile.getFileId();
            File file = fileService.getById(fileId);
            files.add(file);
        }
        contract.setFiles(files);//----将查询到的file列表填充到contract对象------
        return contract;

    }


    // 4.条件查询带分页的方法
    @ApiOperation(value = "分页条件查询委托单列表")
    @PostMapping("pageContractCondition")
    public Map<String, Object> pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @RequestParam Integer page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @RequestParam Integer limit,

            @ApiParam(name = "orderQuery", value = "查询对象")
            @RequestBody(required = false) ContractQuery contractQuery){

        // 创建page对象
        Page<Contract> pageParam = new Page<>(page, limit);

        contractService.pageQuery(pageParam, contractQuery);
        List<Contract> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        Map<String, Object> response=new HashMap<>();
        response.put("total", total);
        response.put("委托单列表", records);

        return  response;
    }


    //-------更新委托单审核状态------
    @ApiOperation(value = "根据id更新委托单审核状态")
    @PutMapping
    public boolean updateContract(
            @ApiParam(name = "id", value = "委托单id", required = true)
            @RequestParam Integer id,
            @ApiParam(name = "reviewStatus", value = "审核", required = true)
            @RequestParam Integer reviewStatus){

        Contract contract = new Contract();
        contract.setId(id);
        contract.setReviewStatus(reviewStatus);

        return contractService.updateById(contract);


    }


}

