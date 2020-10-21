package com.ecust.resource.service;

import com.ecust.resource.entity.EcustPost;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2020-10-21
 */
public interface EcustPostService extends IService<EcustPost> {

    //根据用户获取角色数据
    Map<String, Object> findRoleByUserId(String userId);

    //根据用户分配角色
    void saveUserRoleRealtionShip(String userId, String[] roleId);

    List<EcustPost> selectRoleByUserId(String id);

}
