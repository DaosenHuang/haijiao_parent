package com.haijiao.project;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableSwagger2

public class ProjectApplication {
    public static void main(String[] args){
        SpringApplication.run(ProjectApplication.class, args);

    }
}
