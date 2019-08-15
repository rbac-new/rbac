package com.westos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SmsController {
    @RequestMapping("/system/sms")
    public  String service(){
        return "/system/sms/sms";
    }
}
