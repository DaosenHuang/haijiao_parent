package com.haijiao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


//统一返回结果
@Data    //lombok提供的注解，自动为字段生成set、get方法
public class R {
    @ApiModelProperty(value="是否成功")     //swagger提供的注解
    private boolean success;
    @ApiModelProperty(value="状态码")
    private Integer code;
    @ApiModelProperty(value="返回消息")
    private String message;
    @ApiModelProperty(value="返回数据")
    private Map<String,Object> data=new HashMap<String,Object>();

    //将构造方法私有化
    private R(){}

    //成功静态方法
    public static R ok(){
        R r=new R();
        r.setSuccess(true);
        r.setCode(20000);
        r.setMessage("成功！");
        return r; }
    //失败静态方法
    public static R error(){ R r=new R();
        r.setSuccess(false);
        r.setCode(201);
        r.setMessage("失败！");
        return r;
    }

    public R success(boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R Code(Integer code){
        this.setCode(code);
        return this;
    }

    //返回数据设置为map
    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

    //将键和值放入原先data数据中
    public R data(String key, Object value){
        this.data.put(key,value);
        return this;
    }

}
