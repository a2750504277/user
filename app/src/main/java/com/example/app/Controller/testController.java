package com.example.app.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

            @RequestMapping("/getList")
            public String getMessage(){
                  return "11111";
            }
}
