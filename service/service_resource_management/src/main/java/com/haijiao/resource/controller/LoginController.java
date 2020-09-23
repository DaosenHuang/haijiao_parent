package com.haijiao.resource.controller;


import com.haijiao.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service/user")
@CrossOrigin
public class LoginController {

    //login 方法
    @PostMapping("login")
    public Result login(){
        return Result.ok().data("token", "admin");
    }

    //info 2020-09-23
    @GetMapping("info")
    public Result info(){
        return Result.ok().data("roles","[admin]").data("avatar", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600789647565&di=0cfe0118b40e118fb16e783ceda94794&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201410%2F09%2F20141009224754_AswrQ.jpeg");
    }

}
