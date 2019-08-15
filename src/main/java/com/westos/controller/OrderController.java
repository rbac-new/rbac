package com.westos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class OrderController {
    @RequestMapping("/order/refund")
    public  String refund(){
        return "/order/refund/refund";
    }
    @RequestMapping("/order/search")
    public  String search(){
        return "/order/search/search";
    }
    @RequestMapping("/order/stat")
    public  String stat(){
        return "/order/stat/stat";
    }
}
