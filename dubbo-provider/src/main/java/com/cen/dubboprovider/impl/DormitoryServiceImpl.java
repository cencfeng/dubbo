package com.cen.dubboprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cen.dubboapi.entity.Dormitory;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.DormitoryService;
import com.cen.dubboprovider.mapper.DormitoryMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Override
    public List<Dormitory> getDormitoryName() {
        return dormitoryMapper.getDormitoryName();
    }

    @Override
    public List<Dormitory> getAllRoomByDormitoryName(String dormitoryName) {
        return dormitoryMapper.getAllRoomByDormitoryName(dormitoryName);
    }

    @Override
    public PageInfo<User> getDormitoryInfor(String dormitoryName, String room,Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        System.out.println(currentPage+""+pageSize);
        List<User> dormitoryList = dormitoryMapper.getDormitoryInfor(dormitoryName,room);
        PageInfo<User> pageInfo = new PageInfo<>(dormitoryList);
        return pageInfo;
    }
}
