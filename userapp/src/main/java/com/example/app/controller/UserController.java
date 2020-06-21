package com.example.app.controller;

import com.example.app.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.app.service.*;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Administrator
 * @Description
 * @date 2020/6/16
 */

public class UserController {

           @Autowired
           private userService userService;

           /** @Author Administrator
           * @Description
           * @Date 2020/6/16
           * @Param [id]
           * @return java.lang.String        
           **/

           @RequestMapping("/getUserList")
           public  String getUser(Long id){
               return   userService.getUserById(id);
           }
}
