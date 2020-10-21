package com.ecust.resource.service;

import com.alibaba.fastjson.JSONObject;
import com.ecust.resource.entity.EcustPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-10-21
 */
public interface EcustPermissionService extends IService<EcustPermission> {

    //获取全部菜单
    List<EcustPermission> queryAllMenu();

    //根据角色获取菜单
    List<EcustPermission> selectAllMenu(String roleId);

    //给角色分配权限
    void saveRolePermissionRealtionShip(String roleId, String[] permissionId);

    //递归删除菜单
    void removeChildById(String id);

    //根据用户id获取用户菜单
    List<String> selectPermissionValueByUserId(String id);

    List<JSONObject> selectPermissionByUserId(String id);

    //获取全部菜单
    List<EcustPermission> queryAllMenuGuli();

    //递归删除菜单
    void removeChildByIdGuli(String id);

    //给角色分配权限
    void saveRolePermissionRealtionShipGuli(String roleId, String[] permissionId);

}
