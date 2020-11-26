package com.haijiao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) //设置数据库相关设置不需要自动加载
@EnableDiscoveryClient
@EnableSwagger2
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class);
    }
}
