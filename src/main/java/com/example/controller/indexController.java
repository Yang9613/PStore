package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MOMO on 2017/1/15.
 */
@Controller
public class indexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/main")
    public String main(){
        return "shop/main";
    }
}
