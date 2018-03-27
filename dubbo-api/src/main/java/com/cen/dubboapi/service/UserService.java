package com.cen.dubboapi.service;

import com.cen.dubboapi.entity.Login;
import com.cen.dubboapi.entity.User;

public interface UserService {
    User getUserByName(String account);
    Login getUser(Login login);
}
