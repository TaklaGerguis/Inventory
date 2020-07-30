package com.ecommerce.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/main")
public class HelloController {

    @GetMapping("/menu")
    public String helloEx(){
        return "main-menu";
    }
}
