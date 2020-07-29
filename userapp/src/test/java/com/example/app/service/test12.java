package com.example.app.service;

import com.example.app.AppApplication;
import com.example.app.entity.Coupon;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @Description
 * @date 2020/7/27
 */
@State(Scope.Thread)
public class test12 {
//getCouponListByIds
          private ConfigurableApplicationContext context;
          private IuserCoupon  couponService;

          private Logger logger=Logger.getLogger("test12----");
          //本地二级缓存
          private LoadingCache<Integer, List<Coupon>> couponCache= CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).
            refreshAfterWrite(2,TimeUnit.MINUTES).build(
            new CacheLoader<Integer, List<Coupon>>() {
                    @Override
                    public List<Coupon> load(Integer o) throws Exception {
                        return loadCoupon(o);
                    }
            }
        );

        //二级缓存
        private LoadingCache<Integer,Coupon> couponCache1= CacheBuilder.newBuilder().expireAfterWrite(20, TimeUnit.SECONDS).
            refreshAfterWrite(7,TimeUnit.SECONDS).build(
            new CacheLoader<Integer, Coupon>() {
                    @Override
                    public Coupon load(Integer id) throws Exception {
                        logger.info("查询id:"+id);
                        Coupon coupon=couponService.getCouponListByIds(id+"");
                        Thread.sleep(2000);
                        return coupon;
                    }
            }
    );


          // 定时刷入的 优惠券列表
        private List<Coupon> loadCoupon(Integer o){
              return couponService.getCouponListByStatus();
        }

        //获取数据
      /* private List<Coupon> loadBatchCouponbyId(Integer id){
             return couponService.getCouponListById(id);
    }
*/
        //从缓存中获取数据
        private  List<Coupon> getCouponList(){
            List<Coupon> coupon=null;
             try {
                 coupon= couponCache.get(1);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            return coupon;
        }

        //批量获取用户数据
        private List<Coupon> getCouponbyId(String ids){
             String[] vid=ids.split(":");
             List<String> node=new ArrayList<>();
             List<Coupon> couponList=new ArrayList<>();
             for(String id:vid){
                 Coupon coupon =couponCache1.getIfPresent(Integer.parseInt(id));
                 if(coupon==null){
                       node.add(id);
                 }else{
                     couponList.add(coupon);
                 }
             }

             if(node!=null&&node.size()!=0){
            //     String[]p=new String[node.size()];
                /* for(int i=0;i<node.size();i++){
                     p[i]=node.get(i);
                 }*/
                 List<Coupon> couponList1=couponService.getCouponListById(node);
                 logger.info("==== 查询数据库 =====");
                 try {
                     Thread.sleep(10000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 Map<Integer,Coupon> couponId= couponList1.stream().collect(Collectors.toMap(Coupon::getId, o->o));
                 couponCache1.putAll(couponId);
                 couponList.addAll(couponList1);
             }



              return  couponList;
        }


        public static void main(String[] args) throws RunnerException {
                Options options = new OptionsBuilder().include(test12.class.getName() + ".*")
                        .warmupIterations(2).measurementIterations(2)
                        .forks(1).build();
                new Runner(options).run();
        }

    /**
     * setup初始化容器的时候只执行一次
     */
    @Setup(Level.Trial)
    public void init(){
        String arg = "";
        context = SpringApplication.run(AppApplication.class,arg);
        couponService = context.getBean(IuserCoupon.class);
    }


    /**  10268.020 ops/s   5.512 ops/s
     * benchmark执行多次，此注解代表触发我们所要进行基准测试的方法
     */
  //  @Benchmark
    public void test(){
        List<Coupon> coupons =getCouponList();
        if(coupons==null){
             coupons= couponService.getCouponListByStatus();
        }
        System.out.println(coupons);
    }

    @Benchmark
    public void test1(){
        String ids="1:2:3";
        List<Coupon> listCoupon=getCouponbyId(ids);
        System.out.println(listCoupon);
    }

}
