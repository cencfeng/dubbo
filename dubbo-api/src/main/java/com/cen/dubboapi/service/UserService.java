package com.cen.dubboapi.service;

import com.cen.dubboapi.entity.User;

public interface UserService {
    User getUser(String username);
}
