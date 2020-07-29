package com.example.app.service.impl;

import com.example.app.constant.UserConstant;
import com.example.app.entity.Coupon;
import com.example.app.mapper.CouponDaoMapper;
import com.example.app.service.IuserCoupon;
import com.example.app.service.schedule.UpdateCouponJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Administrator
 * @Description
 * @date 2020/7/17
 */
@Service
public class userCoupon implements IuserCoupon {

    @Autowired
    private CouponDaoMapper couponDao;


    @Override
    public List<Coupon> getUserList(String code) {

        return couponDao.getUserInfoByCode(code);
    }

    @Override
    public List<Coupon> getCouponUserList(int currentPage, int limit) {
        List<Coupon>  couponList=couponDao.getCouponList(5,10);
        return couponList;
    }

    @Override
    public List<Coupon> getCouponListByStatus() {
        List<Coupon>  couponList=couponDao.getCouponListByStatus(UserConstant.USER_FUL,new Date());
        return couponList;
    }

    @Override
    public List<Coupon> getCouponListById( List<String> ids) {
         return couponDao.getCouponListBy(ids);
    }

    private static final Logger logger= LoggerFactory.getLogger(UpdateCouponJob.class);

    @Override
    public Coupon getCouponListByIds(String id) {
        Coupon coupon=null;
        try {
            coupon=couponDao.getUserInfoById(id);
            logger.info("logger coupon id:{},coupon code:{}",coupon.getId(),coupon.getCode());
            return coupon;
        }catch (Exception e){
            logger .error("logger coupon id:{},coupon code:{}",coupon.getId(),coupon.getCode(),e);
        }
        return coupon;
    }

}
