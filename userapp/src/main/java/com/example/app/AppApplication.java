package com.example.app;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 @Description
 @author Administrator
 @date  2020/6/24
*/
@SpringBootApplication
//@EnableDubboConfig
@MapperScan("com.example.app.mapper.CouponDaoMapper")
@EnableScheduling
//@DubboComponentScan("com.example.app.service.dubbo")
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
