package com.ecust.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecust.resource.entity.EcustPost;
import com.ecust.resource.entity.EcustUserPost;
import com.ecust.resource.mapper.EcustPostMapper;
import com.ecust.resource.service.EcustPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ecust.resource.service.EcustUserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-10-21
 */
@Service
public class EcustPostServiceImpl extends ServiceImpl<EcustPostMapper, EcustPost> implements EcustPostService {

    @Autowired
    private EcustUserPostService userPostService;


    //根据用户获取角色数据
    @Override
    public Map<String, Object> findRoleByUserId(String userId) {
        //查询所有的角色
        List<EcustPost> allRolesList =baseMapper.selectList(null);

        //根据用户id，查询用户拥有的角色id
        List<EcustUserPost> existUserRoleList = userPostService.list(new QueryWrapper<EcustUserPost>().eq("user_id", userId).select("role_id"));

        List<String> existRoleList = existUserRoleList.stream().map(c->c.getPostId()).collect(Collectors.toList());

        //对角色进行分类
        List<EcustPost> assignRoles = new ArrayList<EcustPost>();
        for (EcustPost role : allRolesList) {
            //已分配
            if(existRoleList.contains(role.getId())) {
                assignRoles.add(role);
            }
        }

        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assignRoles", assignRoles);
        roleMap.put("allRolesList", allRolesList);
        return roleMap;
    }

    //根据用户分配角色
    @Override
    public void saveUserRoleRealtionShip(String userId, String[] roleIds) {
        userPostService.remove(new QueryWrapper<EcustUserPost>().eq("user_id", userId));

        List<EcustUserPost> userRoleList = new ArrayList<>();
        for(String roleId : roleIds) {
            if(StringUtils.isEmpty(roleId)) continue;
            EcustUserPost userRole = new EcustUserPost();
            userRole.setUserId(userId);
            userRole.setPostId(roleId);

            userRoleList.add(userRole);
        }
        userPostService.saveBatch(userRoleList);
    }

    @Override
    public List<EcustPost> selectRoleByUserId(String id) {
        //根据用户id拥有的角色id
        List<EcustUserPost> userRoleList = userPostService.list(new QueryWrapper<EcustUserPost>().eq("user_id", id).select("role_id"));
        List<String> roleIdList = userRoleList.stream().map(item -> item.getPostId()).collect(Collectors.toList());
        List<EcustPost> roleList = new ArrayList<>();
        if(roleIdList.size() > 0) {
            roleList = baseMapper.selectBatchIds(roleIdList);
        }
        return roleList;
    }

}
