package com.example.app.service.dubbo;


import com.example.userServiceApi.UserServiceApi;
import org.apache.dubbo.config.annotation.DubboService;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Description
 * @date 2020/6/16
 */

@DubboService
public class UserServiceImpl  implements UserServiceApi {

   private static Map<Long,String> map =new HashMap<>();

   static {
             map.put(1L,"name1");
             map.put(2L,"name2");
   }


     @Override
     public String getUserById(Long id) {

               return map.get(id).toString();
     }
}

