package com.ecust.resource.service;

import com.ecust.resource.entity.EcustUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-10-21
 */
public interface EcustUserService extends IService<EcustUser> {

    // 从数据库中取出用户信息
    EcustUser selectByUsername(String username);

}
