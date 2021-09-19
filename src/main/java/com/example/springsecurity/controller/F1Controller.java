package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName F1Controller
 * @Description //dddd
 * @Date 2021/9/19 11:17
 * @Version 1.0
 **/
@RestController
public class F1Controller {

    @GetMapping("/f1")
    public String f1(){
        return "f1";
    }

}
