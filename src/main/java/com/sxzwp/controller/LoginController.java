package com.sxzwp.controller;

import com.sxzwp.domain.User;
import com.sxzwp.service.UserService;
import com.sxzwp.util.Md5Util;
import com.sxzwp.util.UserUtils;
import org.orclight.java.util.captha.CaptchaClient;
import org.orclight.java.util.captha.bean.CaptchaBean;
import org.orclight.java.util.captha.strategy.SimpleCaptchaStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    private CaptchaClient captcha = CaptchaClient.create()
            .width(196)
            .height(39)
            .captchaStrategy(new SimpleCaptchaStrategy())
            .build();

    @Autowired
    UserService userService;
    @Autowired
    UserUtils userUtils;

    //登录
    @RequestMapping("/login")
    public  String login(String username, String password , Model model , HttpSession session){
        System.out.println("/login");
        if(username==null){
            return "redirect:/login.jsp?error=1";
        }
        if(password==null){
            return "redirect:/login.jsp?error=1";
        }
        User user = userService.findByUsername(username);
        if(user == null) {
            return "redirect:/login.jsp?error=1";
    }
        if(!user.getPassword().equals(Md5Util.md5(password))){
            return "redirect:/login.jsp?error=1";
        }

        session.setAttribute("user", user);
        int id = user.getId();
        userUtils.setAttributeModuleDao(session, id);
        return "redirect:/index.jsp";
    }

    //生成验证码
    @RequestMapping("/captcha")
    public void captach(HttpSession session, HttpServletResponse resp) throws IOException {
        // 返回的 CaptcheBean 中包含了图片验证码和答案
        CaptchaBean bean = captcha.generate();
        // 将答案存入 session
        String result = bean.getResult();
        session.setAttribute("result", result);
        System.out.println("答案：" + result);

        // 图片作为响应返回
        resp.setContentType("image/png");
        ImageIO.write(bean.getBufferedImage(), "png", resp.getOutputStream());
    }

    //验证验证码
    @RequestMapping("/checkCaptcha")
    @ResponseBody
    public boolean checkCaptha(HttpSession session,String captcha) {

        // session 中的验证码正确答案
        Object result = session.getAttribute("result");
        if (captcha != null && captcha.equalsIgnoreCase(result.toString())) { // 验证通过
            return true;
        } else { // 验证不通过
            return false;
        }
    }

    @RequestMapping("/logout")
    public  String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.jsp";
    }
}
