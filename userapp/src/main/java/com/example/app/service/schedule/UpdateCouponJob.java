package com.example.app.service.schedule;

import com.example.app.service.IcouponSheduleMap;
import com.example.app.service.IuserCoupon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @Description
 * @date 2020/7/29
 */
@Service
public class UpdateCouponJob {

          @Autowired
          private IcouponSheduleMap icouponSheduleMap;

          private static final Logger logger= LoggerFactory.getLogger(UpdateCouponJob.class);
          @Scheduled(cron="0 0/1 * * * ?")
          public void updateCoupon(){
               logger.info("===enter update coupon job===");
               icouponSheduleMap.updateCouponMap();
          }

}
