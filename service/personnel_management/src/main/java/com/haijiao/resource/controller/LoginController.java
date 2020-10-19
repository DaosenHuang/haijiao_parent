package com.haijiao.resource.controller;


import com.haijiao.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person-service/employee")
public class LoginController {

    //login 方法
    @PostMapping("login")
    public Result login(){
        System.out.printf("into that ...");
        return Result.ok().data("token", "admin");
    }

    //info 2020-09-23哈哈
    @GetMapping("info")
    public Result info(){
        return Result.ok().data("roles","[admin]").data("avatar","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601463159699&di=59b543cea7f4f52faaaf224d4a0c2351&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D757094506%2C3220089312%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1280%26h%3D1584");
    }

}
