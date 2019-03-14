package com.westos.service.impl;

import com.westos.dao.RoleDao;
import com.westos.dao.UserDao;
import com.westos.domain.User;
import com.westos.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        user.setRoles(roleDao.findByUserId(user.getId()));
        return user;
    }

    @Override
    public User findById(int userId) {
       User user= userDao.findById(userId);
        user.setRoles(roleDao.findByUserId(user.getId()));
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            user.setRoles(roleDao.findByUserId(user.getId()));
        }
        return users;
    }

    @Override
    public List<User> findByPage(int page, int rows) {
        return userDao.findByPage((page-1)*rows,rows);
    }

    @Override
    public int findCount() {
        return userDao.findCount();
    }

    @Override
    public void insert(User user) {

        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int userId) {
        userDao.delete(userId);
        userDao.deleteUserRole(userId);
    }

    @Override
    public void modifyRoles(int userId, int[] roleIds) {
        userDao.deleteUserRole(userId);
        for (int i = 0; i < roleIds.length; i++) {
            userDao.insertUserRole(userId,roleIds[i]);
        }
    }
}
