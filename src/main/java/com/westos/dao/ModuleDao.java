package com.westos.dao;

import com.westos.domain.Module;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ModuleDao {

    /**
     * 查询所有模块
     * @return 模块集合
     */
    //@Select("select * from rbac_module")
    List<Module> findAll();

    /**
     * 查询某一角色的模块
     * @param roleId 角色编号
     * @return 模块集合
     */
    @Select("select distinct id ,name,pid,code from  rbac_role_module,rbac_module where role_id= #{roleId} and id=module_id")
    List<Module> findByRoleId(int roleId);
}
