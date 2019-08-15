package com.sxzwp.dao;

import com.sxzwp.domain.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yihang
 */
public interface RoleDao {

    /**
     * 查询所有角色
     *
     * @return 角色集合
     */
    @Select("select id,name from rbac_role")
    List<Role> findAll();

    /**
     * 查询某一用户的角色
     * @param userId 用户编号
     * @return 角色集合
     */
    @Select("select * from rbac_role where id in(select role_id from rbac_user_role where user_id=#{userId})")
    List<Role> findByUserId(int userId);

    /**
     * 删除某角色的所有模块
     * @param roleId 角色编号
     */
    @Delete("delete from rbac_role_module where role_id=#{roleId}")
    void deleteRoleModule(int roleId);

    /**
     * 为该角色添加模块
     * @param roleId 角色编号
     * @param moduleId 模块编号
     */
    @Insert("insert into rbac_role_module(role_id,module_id) values(#{a},#{b})")
    void insertRoleModule(@Param("a") int roleId, @Param("b") int moduleId);
}
