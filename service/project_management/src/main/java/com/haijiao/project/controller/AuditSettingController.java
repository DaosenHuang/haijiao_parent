package com.haijiao.project.controller;


import com.haijiao.project.entity.AuditSetting;
import com.haijiao.project.service.AuditSettingService;
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
 * @since 2020-11-26
 */
@RestController
@RequestMapping("/project/audit-settings")
public class AuditSettingController {

    @Autowired
    private AuditSettingService auditSettingService;

    @PostMapping
    @ApiOperation(value = "新增一个审核设置")
    public AuditSetting addAuditSetting(
            @ApiParam(name="auditSetting", value="审核人设置", required=true)
            @RequestBody AuditSetting auditSetting) {

            return auditSettingService.addAuditSetting(auditSetting);

    }

    @PutMapping
    @ApiOperation(value="修改审核人设置")
    public AuditSetting updateSetting(
            @ApiParam(name="id", value="审核人设置", required = true)
            @RequestParam Integer id,

            @ApiParam(name="auditors", value="审核人id", required = true)
            @RequestParam List<Integer> auditors) {

        AuditSetting auditSetting=new AuditSetting();

        auditSetting.setId(id)
                    .setAuditors(auditors);
        auditSettingService.updateById(auditSetting);

        return auditSettingService.getById(id);

    }

    @GetMapping
    @ApiOperation(value = "根据id查询委托单")
    public AuditSetting getAuditSettingById(
            @ApiParam(name="id", value="设置的id", required = true)
            @RequestParam Integer id) {

        return auditSettingService.getById(id);
    }

}

