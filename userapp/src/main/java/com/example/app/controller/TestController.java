package com.example.app.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 @Description
 @author Administrator
 @date  2020/6/24
*/
@RestController
public class TestController {

            @RequestMapping("/getLists")
            public String getMessage(){
                  return "11111";
            }



}
