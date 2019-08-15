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

    @Autowired
   ModuleDao moduleDao;
    @Override
    public List<Module> findAll() {
        return moduleDao.findAll();
    }

    @Override
    public List<Module> findByRoleId(int roleId) {
        return  moduleDao.findByRoleId(roleId);
    }


}
