package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description //TODO
 * @Date 2021/8/2710:21
 * @Version 1.0
 **/

@RestController
public class TestController {

     @GetMapping("/demo")
    public String demo(){
        return "demo";
    }
    @GetMapping
    public String home(){
         return "home";
    }

}
