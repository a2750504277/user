package com.example.app.service;

import com.example.app.entity.Coupon;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @Description
 * @date 2020/7/17
 */
public interface IuserCoupon {


          /* show 方法的简述.
          * <p>show 获取用户数据<br>
          * @param []
          * @return java.util.List<com.example.app.entity.Coupon>
          * @Author Administrator
           * @Date 2020/7/22
           */
          List<Coupon> getUserList(String code);

           /** show 方法的简述.
            * <p>show 获取获得可以使用优惠券列表<<br>
           * @param [currentPage 当前页数, limit 显示行数]
           * @return java.util.List<com.example.app.entity.Coupon>
           * @Author Administrator
            * @Date 2020/7/24
            */
           List<Coupon> getCouponUserList(int currentPage,int limit);

           /** show 方法的简述.
           * <p>show 方法的详细说明第二行<br>
           * @return java.util.List<com.example.app.entity.Coupon>
           * @Author Administrator
            * @Date 2020/7/24
            */
           List<Coupon> getCouponListByStatus();

           /* show 方法的简述.
           * <p>show 方法的详细说明第二行<br>
           * @param [id]
           * @return java.util.List<com.example.app.entity.Coupon>
           * @Author Administrator
            * @Date 2020/7/28
            */
           List<Coupon> getCouponListById( List<String>id);


            /* show 方法的简述.
             * <p>show 通过id 获取用户信息<br>
             * @param [id]
             * @return java.util.List<com.example.app.entity.Coupon>
             * @Author Administrator
             * @Date 2020/7/28
             */
            Coupon getCouponListByIds(String id);



}


