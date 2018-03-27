package com.cen.dubboprovider.mapper;

import com.cen.dubboapi.entity.Login;
import com.cen.dubboapi.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByName(String account);
    Login getUser(Login login);
}
