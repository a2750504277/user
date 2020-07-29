package com.example.app.service;

import com.example.app.AppApplication;
import com.example.app.entity.Coupon;
import com.example.app.entity.User;
import com.example.app.mapper.CouponDaoMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Random;

/**
 * @author Administrator
 * @Description
 * @date 2020/7/16
 */
@SpringBootTest(classes = AppApplication.class)
@MapperScan(basePackageClasses = CouponDaoMapper.class)
public class test3 {

    @Autowired
    private CouponDaoMapper couponDaoMapper;

    @Test
    void contextLoads() {

        for(int i=0;i<=100000;i++){
            Coupon coupon=new Coupon();
            Random random=new Random();
            coupon.setCode( random.nextInt(100000)+"");
            coupon.setAchiveAmount(3);
            coupon.setPicUrl("/url");
            coupon.setReduceAmount(34);
            coupon.setStatus(0);
            coupon.setStock(12);
            coupon.setTitle("asdasd");
            coupon.setCreateUser("212");
            coupon.setUpdateUser("23213");
            coupon.setCreateTime(new Date());
            coupon.setUpdateTime(new Date());
            couponDaoMapper.insert(coupon);
        }



    }



}
