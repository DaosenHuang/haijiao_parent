package com.haijiao.resource;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.haijiao"})
public class SourceApplication {
    public static void main(String[] args){
        SpringApplication.run(SourceApplication.class, args);

    }
}
