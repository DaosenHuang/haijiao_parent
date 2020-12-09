package com.haijiao.project.service;

import com.haijiao.project.entity.AuditSetting;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hy
 * @since 2020-11-26
 */
public interface AuditSettingService extends IService<AuditSetting> {

    //根据审核类型查询审核设置
    AuditSetting searchByAuditType(String auditorType);

    //新增审核设置
    AuditSetting addAuditSetting(AuditSetting auditSetting);

}
