package com.sxzwp.service;


import com.sxzwp.domain.Module;

import java.util.List;

/**
 * @author yihang
 */
public interface ModuleService {

    /**
     * 查询所有模块（包含了层级关系）
     * @return 模块集合
     */
    List<Module> findAll();

    /**
     * 查询某一角色的模块
     * @param roleId 角色编号
     * @return 模块集合
     */
    List<Module> findByRoleId(int roleId);
}
