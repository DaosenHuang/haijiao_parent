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

    AuditSetting searchByAuditType(String auditorType);

}
