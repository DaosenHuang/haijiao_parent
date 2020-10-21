package com.ecust.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ecust.resource.entity.EcustUser;
import com.ecust.resource.mapper.EcustUserMapper;
import com.ecust.resource.service.EcustUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-10-21
 */
@Service
public class EcustUserServiceImpl extends ServiceImpl<EcustUserMapper, EcustUser> implements EcustUserService {


    @Override
    public EcustUser selectByUsername(String username) {
        return baseMapper.selectOne(new QueryWrapper<EcustUser>().eq("username", username));
    }

}
