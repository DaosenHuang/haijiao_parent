package com.haijiao.resource;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages={"com.haijiao" })

public class ProjectApplication {
    public static void main(String[] args){
        SpringApplication.run(ProjectApplication.class, args);

    }
}
