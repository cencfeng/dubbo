package com.cen.dubboprovider.mapper;

import com.cen.dubboapi.entity.Dormitory;
import com.cen.dubboapi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface DormitoryMapper {
    List<Dormitory> getDormitoryName();
    List<Dormitory> getAllRoomByDormitoryName(String dormitoryName);
    List<Dormitory> getLeftRoomByDormitory(String dormitoryName);
    List<Dormitory> getDormitoryInfor(@Param("dormitoryName") String dormitoryName, @Param("room") String room,@Param("searchDate")String searchDate);
    List<User> getDormitoryMember(@Param("dormitoryName") String dormitoryName, @Param("room") String room);
    int applyDormitory(@Param("txtAccount")String txtAccount, @Param("txtName")String txtName, @Param("dormitoryName")String dormitoryName, @Param("room")String room, @Param("stayintime")String stayintime);
}
