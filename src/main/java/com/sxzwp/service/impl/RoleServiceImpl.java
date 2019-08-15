package com.sxzwp.service.impl;

import com.sxzwp.dao.ModuleDao;
import com.sxzwp.dao.RoleDao;
import com.sxzwp.domain.Role;
import com.sxzwp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
//    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//   RoleDao roleDao =context.getBean(RoleDao.class);
//    ModuleDao moduleDao = context.getBean(ModuleDao.class);
    @Autowired
    ModuleDao moduleDao;
    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        List<Role> all = roleDao.findAll();
        for (Role role : all) {
            role.setModules(moduleDao.findByRoleId(role.getId()));
        }
        return all;
    }

    @Override
    public List<Role> findByUserId(int userId) {
        List<Role> all = roleDao.findByUserId(userId);
        for (Role role : all) {
            role.setModules(moduleDao.findByRoleId(role.getId()));
        }
        return all;
    }

    @Override
    public void modifyRoleModule(int roleId, int[] moduleIds) {
            roleDao.deleteRoleModule(roleId);
        for (int i = 0; i < moduleIds.length; i++) {
            roleDao.insertRoleModule(roleId,moduleIds[i]);
        }
    }
}
