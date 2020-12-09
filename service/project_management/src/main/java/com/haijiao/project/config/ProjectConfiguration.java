package com.haijiao.project.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.haijiao.project.mapper")
public class ProjectConfiguration {


    /**
     * 加上分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
