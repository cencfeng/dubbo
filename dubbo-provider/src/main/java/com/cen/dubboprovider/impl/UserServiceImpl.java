package com.cen.dubboprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cen.dubboapi.entity.Login;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.UserService;
import com.cen.dubboprovider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String account) {
        return userMapper.getUserByName(account);
    }

    @Override
    public Login getUser(Login login) {
        return userMapper.getUser(login);
    }
}
