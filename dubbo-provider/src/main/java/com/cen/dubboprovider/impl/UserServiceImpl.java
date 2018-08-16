package com.cen.dubboprovider.impl;

//import com.alibaba.dubbo.config.annotation.Service;
import com.cen.dubboapi.entity.Login;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.UserService;
import com.cen.dubboprovider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
//和事物,shiro冲突,改用xml配置发布
//@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    public User getUserByName(String account) {
        return userMapper.getUserByName(account);
    }

    @Override
    public Login getUser(Login login) {
        return userMapper.getUser(login);
    }

    @Override
    public void insertUser(Map<String, Object> hasmap) {
        userMapper.insertUser(hasmap);
    }
}
