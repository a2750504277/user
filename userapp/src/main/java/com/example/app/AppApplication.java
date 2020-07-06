package com.example.app;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 @Description
 @author Administrator
 @date  2020/6/24
*/
@SpringBootApplication
@EnableDubboConfig
@DubboComponentScan("com.example.app.service.dubbo")
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
