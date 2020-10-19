package com.haijiao.resource.client;


import com.haijiao.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("project-management")
@Component
public interface ModuleClient {

    //定义调用的方法路径
    //根据模块id删除对应模块
    //@PathVariable注解一定要指定参数名称，否则出错
//删除模块方法
    @ApiOperation(value="逻辑删除模块")
    @DeleteMapping("/module-service/ecu-module/{id}")
    // PathVarible注解一定要指定参数名称，否则出错
    public Result removeEcuModule(@ApiParam(name="id",value="模块id",required=true) @PathVariable("id") Integer id);

}
