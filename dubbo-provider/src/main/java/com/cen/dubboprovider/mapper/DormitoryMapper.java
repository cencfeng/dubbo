package com.cen.dubboprovider.mapper;

import com.cen.dubboapi.entity.Dormitory;
import com.cen.dubboapi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DormitoryMapper {
    List<Dormitory> getDormitoryName();
    List<Dormitory> getAllRoomByDormitoryName(String dormitoryName);
    List<User> getDormitoryInfor(@Param("dormitoryName") String dormitoryName, @Param("room") String room);
}
