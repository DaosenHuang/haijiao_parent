package com.haijiao.detection;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableDiscoveryClient
// @ComponentScan(basePackages = "com.haijiao.servicebase")
@EnableSwagger2
public class DetectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(DetectionApplication.class);
    }
}
