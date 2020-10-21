package com.ecust.resource.mapper;

import com.ecust.resource.entity.EcustPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-10-21
 */
public interface EcustPermissionMapper extends BaseMapper<EcustPermission> {


    List<String> selectPermissionValueByUserId(String id);

    List<String> selectAllPermissionValue();

    List<EcustPermission> selectPermissionByUserId(String userId);

}
