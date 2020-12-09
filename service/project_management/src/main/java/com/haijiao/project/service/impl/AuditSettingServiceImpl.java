package com.haijiao.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haijiao.project.entity.AuditSetting;
import com.haijiao.project.mapper.AuditSettingMapper;
import com.haijiao.project.service.AuditSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hy
 * @since 2020-11-26
 */
@Service
public class AuditSettingServiceImpl extends ServiceImpl<AuditSettingMapper, AuditSetting> implements AuditSettingService {

    @Autowired
    private AuditSettingMapper auditSettingMapper;

    /**
     * 根据审核类型查找对应的审核设置
     * @param auditType
     * @return
     */
    public AuditSetting searchByAuditType(String auditType) {
        QueryWrapper<AuditSetting> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("audit_type", auditType);

        return auditSettingMapper.selectOne(queryWrapper);
    }

    /**
     * 新增审核设置
     */
    public AuditSetting addAuditSetting(AuditSetting auditSetting) {

        auditSettingMapper.insert(auditSetting);
        return auditSetting;

    }

}
