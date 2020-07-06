package com.example.app.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @Description
 * @date 2020/6/16
 */

@RestController
public class UserController {



           /** @Author Administrator
           * @Description
           * @Date 2020/6/16
           * @Param [id]
           * @return java.lang.String
           **/
           @RequestMapping("/getUserList")
           public  String getUser(Long id){
               return   null;
           }
}
