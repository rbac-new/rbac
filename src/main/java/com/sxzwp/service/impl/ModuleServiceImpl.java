package com.sxzwp.service.impl;

import com.sxzwp.dao.ModuleDao;
import com.sxzwp.domain.Module;
import com.sxzwp.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
@Service
public class ModuleServiceImpl implements ModuleService {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        ModuleDao moduleDao = context.getBean(ModuleDao.class);
    @Autowired
   ModuleDao moduleDao;
    @Override
    public List<Module> findAll() {
//        List<Module> listAll = moduleDao.findAll();
//        List<Module> list = new ArrayList<>();
//        for(Module module:listAll){
//            int i=module.getId()/10;
//            if(i==0){
//                list.add(module);
//            }else{
//                for(Module module1:listAll){
//                    if(module1.getId()==i){
//                        module1.getChildren().add(module);
//                    }
//                }
//            }
//        }
//        return  list;
        return moduleDao.findAll();
    }

    @Override
    public List<Module> findByRoleId(int roleId) {
        return  moduleDao.findByRoleId(roleId);
    }


}
