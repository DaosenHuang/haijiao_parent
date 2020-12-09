package com.haijiao.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

//自动添加创建时间与更新时间
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject){
        //属性名称，不是字段名称
        log.info("开始自动注入！");
        this.strictInsertFill(metaObject,"gmtCreate",()->LocalDateTime.now(), LocalDateTime.class);
        this.strictInsertFill(metaObject,"gmtModified",()->LocalDateTime.now(), LocalDateTime.class);
    }

    @Override
    public void updateFill(MetaObject metaObject){
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

}
