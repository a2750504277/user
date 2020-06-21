package com.example.app.controller;


import com.example.app.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.app.service.*;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class TestController {

            @RequestMapping("/getList")
            public String getMessage(){
                  return "11111";
            }


            /*@RequestMapping(value="/getUserList",method =POST)
            public  String getUser(Long id){
                return   userService.getUserById(id);
           }*/

}
