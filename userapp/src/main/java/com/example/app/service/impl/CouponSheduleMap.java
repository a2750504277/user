package com.example.app.service.impl;

import com.example.app.entity.Coupon;
import com.example.app.service.IcouponSheduleMap;
import com.example.app.service.IuserCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 * @Description
 * @date 2020/7/29
 */
@Service
public class CouponSheduleMap implements IcouponSheduleMap {

    private static Map<Integer,Coupon> currentMap=new ConcurrentHashMap();
    @Autowired
    private IuserCoupon iuserCoupon;
    @Override
    public void updateCouponMap(){
        Map map=new ConcurrentHashMap();
        Coupon coupon= iuserCoupon.getCouponListByIds("1");
        map.put(1,coupon);
        currentMap=map;
    }
    @Override
    public Coupon getCouponList(){
        return   currentMap.get(1);
    }

}
