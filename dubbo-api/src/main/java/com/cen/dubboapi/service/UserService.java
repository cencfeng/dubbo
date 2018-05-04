package com.cen.dubboapi.service;

import com.cen.dubboapi.entity.Login;
import com.cen.dubboapi.entity.User;

import java.util.Map;

public interface UserService {
    User getUserByName(String account);
    Login getUser(Login login);
    User getUserByAccount(String account);
    void insertUser(Map<String, Object> hasmap);
}
