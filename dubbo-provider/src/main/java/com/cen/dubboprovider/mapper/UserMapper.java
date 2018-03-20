package com.cen.dubboprovider.mapper;

import com.cen.dubboapi.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUser(String username);
}
