package com.haijiao.resource;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@EnableFeignClients  // 服务调用
@EnableDiscoveryClient  //加入服务发现注解
@SpringBootApplication
@ComponentScan(basePackages={"com.haijiao"})
public class SourceApplication {
    public static void main(String[] args){
        SpringApplication.run(SourceApplication.class, args);

    }
}
