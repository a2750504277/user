package com.example.app.service;

import com.example.app.entity.Coupon;

import java.util.List;

/**
 * @author Administrator
 * @Description
 * @date 2020/7/29
 */
public interface IcouponSheduleMap {


    /** show 方法的简述.
     * <p>show 方法的详细说明第二行<br>
     * @param []
     * @return void
     * @Author Administrator
     * @Date 2020/7/29
     */
    void updateCouponMap();

    /** show 方法的简述.
     * <p>show 方法的详细说明第一行<br>
     * @param []
     * @return java.util.List<com.example.app.entity.Coupon>
     * @Author Administrator
     * @Date 2020/7/29
     */
    Coupon getCouponList();
}
