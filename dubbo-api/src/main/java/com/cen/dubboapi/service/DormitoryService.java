package com.cen.dubboapi.service;

import com.cen.dubboapi.entity.Dormitory;
import com.cen.dubboapi.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DormitoryService {
    List<Dormitory> getDormitoryName();
    List<Dormitory> getAllRoomByDormitoryName(String dormitoryName);
    PageInfo<User> getDormitoryInfor(String dormitoryName, String room,Integer currentPage,Integer pageSize);
}
