package com.example.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AppApplication.class)
@MapperScan
class AppApplicationTests {

     private com.example.app.mapper.CouponDaoMapper CouponDaoMapper;



}
