package com.westos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class EmailController {
    @RequestMapping("/system/email")
    public  String service(){

        return "/system/email/email";
    }
}
