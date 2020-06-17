package com.example.app.service.impl;


import com.example.app.service.userService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Description
 * @date 2020/6/16
 */

@Service
public class userServiceImpl implements userService {

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