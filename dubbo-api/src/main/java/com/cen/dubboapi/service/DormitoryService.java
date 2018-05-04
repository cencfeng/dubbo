package com.cen.dubboapi.service;

import com.cen.dubboapi.entity.Dormitory;
import com.cen.dubboapi.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DormitoryService {
    List<Dormitory> getDormitoryName();
    List<Dormitory> getAllRoomByDormitoryName(String dormitoryName);
    PageInfo<Dormitory> getDormitoryInfor(String dormitoryName, String room,String searchDate,Integer currentPage,Integer pageSize);
    PageInfo<User> getDormitoryMember(String dormitoryName, String room,Integer currentPage,Integer pageSize);
    List<Dormitory> getLeftRoomByDormitory(String dormitoryName);
    int applyDormitory(String txtAccount,String txtName,String dormitoryName,String room);
}
