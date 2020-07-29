package com.example.app.mapper;


import com.example.app.entity.Coupon;
import com.example.app.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * (Coupon)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-16 15:21:35
 */
@Mapper
@Component
public interface CouponDaoMapper {

  /** show 方法的简述.
  * <p>show 向 coupon 插入数据<br>
  * <p>show 方法的详细说明第二行<br>
  * @param coupon
  * @return int
  * @Author Administrator
   * @Date 2020/7/22
   */
   @Insert("insert into coupon(code, title, pic_url, achive_amount, reduce_amount, stock, status, create_time, update_time, create_user, update_user) " +
           "values (#{code}, #{title}, #{picUrl}, #{achiveAmount}, #{reduceAmount}, #{stock}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
   @Options(useGeneratedKeys = true,keyColumn="id",keyProperty="id")
   int insert(Coupon coupon);

   /** show 方法的简述.
   * <p>show 通过优惠券码获取 优惠券<br>
   * @param []
   * @return java.util.List<com.example.app.entity.User>
   * @Author Administrator
    * @Date 2020/7/22
    */
   @Select(
      "select id,code from coupon where code=#{code}"
    )
   List<Coupon> getUserInfoByCode(@Param("code") String code);

     /** show 方法的简述.
      * <p>show 获得可以使用优惠券列表<br>
     * @param [offset, limit]  offset 初始行数  limit  限制行数
     * @return java.util.List<com.example.app.entity.Coupon>
     * @Author Administrator
      * @Date 2020/7/24
      */
     @Select(" select" +
             "  id, code, title, pic_url, achive_amount, reduce_amount, stock, status, create_time, update_time, create_user, update_user\n" +
             "  from coupon\n" +
             "  where id >= (select id from coupon limit #{offset},1 ) limit #{limit} ")
     List<Coupon> getCouponList(@Param("offset") int offset,@Param("limit") int limit);


     /** show 方法的简述.
     * <p>show 方法的详细说明第一行<br>
     * @param [status 状态, currentDate 当前时间]
     * @return java.util.List<com.example.app.entity.Coupon>
     * @Author Administrator
      * @Date 2020/7/24
      */
    @Select(" select" +
            "  id, code, title, pic_url, achive_amount, reduce_amount, stock, status, create_time, update_time, create_user, update_user\n" +
            "  from coupon\n" +
            "  where status= #{status} and #{currentDate} >=start_time and #{currentDate} <=end_time ")
    List<Coupon> getCouponListByStatus(@Param("status") int status,@Param("currentDate") Date currentDate);

    @Select("<script>"
            + "SELECT id, code, title FROM coupon WHERE id IN "
            + "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    List<Coupon> getCouponListBy(@Param("ids")List<String> ids);

    /** show 方法的简述.
     * <p>show 通过id 获得数据<br>
     * @param []
     * @return java.util.List<com.example.app.entity.User>
     * @Author Administrator
     * @Date 2020/7/22
     */
    @Select(
            "select id,code from coupon where id=#{id}"
    )
    Coupon getUserInfoById(@Param("id") String id);

}