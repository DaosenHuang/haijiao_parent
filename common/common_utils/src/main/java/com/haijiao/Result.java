package com.haijiao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


//统一返回结果
@Data    //lombok提供的注解，自动为字段生成set、get方法
public class Result {
    @ApiModelProperty(value="是否成功")     //swagger提供的注解
    private boolean success;
    @ApiModelProperty(value="状态码")
    private Integer code;
    @ApiModelProperty(value="返回消息")
    private String message;
    @ApiModelProperty(value="返回数据")
    private Map<String,Object> data=new HashMap<String,Object>();

    //将构造方法私有化
    private Result(){}

    //成功静态方法
    public static Result ok(){
        Result r=new Result();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage("成功！");
        return r; }
    //失败静态方法
    public static Result error(){ Result r=new Result();
        r.setSuccess(false);
        r.setCode(201);
        r.setMessage("失败！");
        return r;
    }

    public Result success(boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result Code(Integer code){
        this.setCode(code);
        return this;
    }

    //返回数据设置为map
    public Result data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

    //将键和值放入原先data数据中
    public Result data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

}
