package com.haijiao.resource.service.impl;

import com.haijiao.resource.entity.Employee;
import com.haijiao.resource.mapper.EmployeeMapper;
import com.haijiao.resource.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-08-31
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
