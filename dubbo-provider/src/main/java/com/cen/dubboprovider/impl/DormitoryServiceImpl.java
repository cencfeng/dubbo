package com.cen.dubboprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cen.dubboapi.entity.Dormitory;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.DormitoryService;
import com.cen.dubboprovider.mapper.DormitoryMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//@Service
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
    public PageInfo<Dormitory> getDormitoryInfor(String dormitoryName, String room,String searchDate,Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        /*Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        if(searchDate.equals("")) {
            searchDate = sdf.format(d).toString();
        }
        System.out.println(searchDate);*/
            List<Dormitory> dormitoryList = dormitoryMapper.getDormitoryInfor(dormitoryName,room,searchDate);
        PageInfo<Dormitory> pageInfo = new PageInfo<>(dormitoryList);
        return pageInfo;
    }

    @Override
    public PageInfo<User> getDormitoryMember(String dormitoryName, String room, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> userList = dormitoryMapper.getDormitoryMember(dormitoryName,room);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public List<Dormitory> getLeftRoomByDormitory(String dormitoryName) {
        return dormitoryMapper.getLeftRoomByDormitory(dormitoryName);
    }

    @Override
    @Transactional
    public int applyDormitory(String txtAccount, String txtName, String dormitoryName, String room) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int row = dormitoryMapper.applyDormitory(txtAccount,txtName,dormitoryName,room,sdf.format(date));
        return row;
    }
}
