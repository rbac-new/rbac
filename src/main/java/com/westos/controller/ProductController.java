package com.westos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @RequestMapping("/product/inventory")
    public  String incentory(){
        return "/product/inventory/inventory";
    }
    @RequestMapping("/product/onoff")
    public  String onoff(){
        return "/product/onoff/onoff";
    }
    @RequestMapping("/product/search")
    public  String search(){
        return "/product/search/search";
    }
    @RequestMapping("/product/stat")
    public  String stat(){
        return "/product/stat/stat";
    }
}
