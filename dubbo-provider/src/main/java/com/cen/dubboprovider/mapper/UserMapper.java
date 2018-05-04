package com.cen.dubboprovider.mapper;

import com.cen.dubboapi.entity.Login;
import com.cen.dubboapi.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
    User getUserByName(String account);
    Login getUser(Login login);
    User getUserByAccount(String account);
    void insertUser(Map<String, Object> hasmap);
}
