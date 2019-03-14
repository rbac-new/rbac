package com.westos.controller;

import com.westos.domain.Module;
import com.westos.domain.Role;
import com.westos.domain.User;
import com.westos.service.ModuleService;
import com.westos.service.RoleService;
import com.westos.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    ModuleService moduleService;
    @Autowired
    UserUtils userUtils;
    @RequestMapping("/system/role/all")
    public  String all(Model model){
        List<Role> list = roleService.findAll();
        model.addAttribute("list", list);
        return "/system/role/all";
    }

    @RequestMapping("/system/role/tomodifymodule")
    public  String toModifyModule(int id,Model model){
        List<Module> modules = moduleService.findAll();
        List<Module> roleModules = moduleService.findByRoleId(id);
        List<Integer> ids = new ArrayList<>();
        for (Module roleModule : roleModules) {
            ids.add(roleModule.getId());
        }

        model.addAttribute("modules", modules);
        model.addAttribute("ids", ids);
        model.addAttribute("roleModules",roleModules);
        return "system/role/tomodifymodule";
    }

    @RequestMapping("/system/role/modifymodule")
    public String modifyModule(int roleId,String[] moduleId,HttpSession session){
        int[] moduleIds =new int[moduleId.length];
        for (int i = 0; i < moduleIds.length; i++) {
            System.out.println(moduleId[i]);
            moduleIds[i] = Integer.valueOf(moduleId[i]);
        }
        roleService.modifyRoleModule(roleId,moduleIds);
        User user = (User)session.getAttribute("user");
        userUtils.setAttributeModuleDao(session, user.getId());
        return "redirect:/system/role/all";


    }

}
