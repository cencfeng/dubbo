package com.cen.dubboprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.UserService;
import com.cen.dubboprovider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUser(String username) {
        System.out.println(username);
        System.out.println("dubboprovider 发布服务");
        return userMapper.getUser(username);
    }
}
