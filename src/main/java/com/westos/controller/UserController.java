package com.westos.controller;

import com.westos.domain.Module;
import com.westos.domain.Role;
import com.westos.domain.User;
import com.westos.service.RoleService;
import com.westos.service.UserService;
import com.westos.util.Md5Util;
import com.westos.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    RoleService roleService;
    @RequestMapping("/system/user/page")
    public String findByPage(@RequestParam(defaultValue = "1") Integer page ,
                             @RequestParam(defaultValue = "5") Integer rows, Model model) {
        // 当前页集合
        List<User> list = userService.findByPage(page, rows);
        // 总记录数
        int count = userService.findCount();
        // 总页数
        int total = (count - 1) / rows + 1;

        // 将数据放入模型
        model.addAttribute("list", list);
        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("rows", rows);
        return "/system/user/page";
    }
    @RequestMapping("/system/user/toadd")
    public String toadd(){
        return "/system/user/toadd";
    }

    @RequestMapping("/system/user/add")
    public String add(User user){
        user.setPassword(Md5Util.md5(user.getPassword()));
        userService.insert(user);
        return "redirect:/system/user/page";
    }


    @RequestMapping("/system/user/toupdate")
    public String toUpDate(int id,Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/system/user/toupdate";
    }

    @RequestMapping("/system/user/update")
    public  String upDate(User user){
        user.setPassword(Md5Util.md5(user.getPassword()));
        userService.update(user);
        return "redirect:/system/user/page";
    }
    @RequestMapping("/system/user/delete")
    public String delete(int id){
       userService.delete(id);
       return "redirect:/system/user/page";
    }

    @RequestMapping("/system/user/tomodifyrole")
    public  String toModifyRole(int userId, Model model){
        List<Role> roles = roleService.findAll();
        List<Role> userRoles = roleService.findByUserId(userId);
        model.addAttribute("roles", roles);
        model.addAttribute("userRoles", userRoles);
        System.out.println("====================");
        for (Role userRole : userRoles) {
            System.out.println(userRole.getName());
        }
        System.out.println("====================");
        model.addAttribute("userId", userId);

        return  "/system/user/tomodifyrole";
    }

    @RequestMapping("/system/user/modifyrole")
    public String modifyRole(int userId, String[] roles){
        int[] roleIds = new int[roles.length];
        for (int i = 0; i < roles.length; i++) {
            roleIds[i] = Integer.valueOf(roles[i]);
        }
       userService.modifyRoles(userId,roleIds);
        return "redirect:/system/user/page";
    }

}
