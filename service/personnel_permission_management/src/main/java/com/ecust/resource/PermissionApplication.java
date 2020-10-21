package com.ecust.resource;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.ecust")
@MapperScan("com.ecust.resource.mapper")
public class PermissionApplication {
    public static void main(String[] args){
        SpringApplication.run(PermissionApplication.class, args);
    }
}
