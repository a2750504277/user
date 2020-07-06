package com.example.userServiceApi;


/** @Author Administrator
* @Description
* @Date 2020/6/23
* @Param
* @return
**/
public interface UserServiceApi {



      /** show 方法的简述.
      * <p>show 通过用户id获得用户<br>
      * @param id 用户id
      * @return java.lang.String
      * @Author Administrator
       * @Date 2020/6/24
       */
        String getUserById(Long id);

}
