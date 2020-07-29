package com.example.app.controller;


import com.example.app.entity.Coupon;
import com.example.app.service.IcouponSheduleMap;
import com.example.app.service.IuserCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 * @Description
 * @date 2020/6/16
 */

@RestController
public class UserController {

            @Autowired
            private IuserCoupon iuserCoupon;


            @RequestMapping("/couponList")
            public List<Coupon> getCouponList(String code){


                return  iuserCoupon.getUserList(code);
            }

            /** show 方法的简述.
            * <p>show 返回可以使用的优惠券列表<br>
            * @param [currentPage 当前页, index 每页显示数]
            * @return java.util.List<com.example.app.entity.Coupon>
            * @Author Administrator
             * @Date 2020/7/24
             */
            @RequestMapping("/couponPartionList")
            public Object getCouponList(Integer currentPage,Integer index){
                  if(currentPage==null){
                      return "请输入正确的页数";
                  }
                  if(index==null){
                      return "请输入正确的显示行数";
                  }
                  List<Coupon> couponList=iuserCoupon.getCouponUserList(currentPage,index);
                  return couponList;
            }


            @RequestMapping("/couponUserList")
            public Object getCouponList(){
                List<Coupon> couponList=iuserCoupon.getCouponListByStatus();
                return couponList;
            }

            @Autowired
            private IcouponSheduleMap icouponSheduleMap;

            @RequestMapping("/tetCouponList")
             public Object tetCouponList(){
                Coupon couponList=icouponSheduleMap.getCouponList();
                return couponList;
            }

            @RequestMapping("/getCouponById")
            public Object getCouponById(String id){
                Coupon couponList=iuserCoupon.getCouponListByIds(id);
                return couponList;
            }

}
