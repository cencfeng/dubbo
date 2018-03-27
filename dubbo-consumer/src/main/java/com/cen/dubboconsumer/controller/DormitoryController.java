package com.cen.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cen.dubboapi.entity.Dormitory;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.DormitoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dormitory")
public class DormitoryController {
    @Reference
    private DormitoryService dormitoryService;
    @RequestMapping("/getdormitoryname")
    @ResponseBody
    public List<Dormitory> getDormitoryName(){
        return dormitoryService.getDormitoryName();
    }
    @RequestMapping("/getallroombydormitoryname")
    @ResponseBody
    public List<Dormitory> getAllRoomeByDormitoryName(String dormitoryName){
        return dormitoryService.getAllRoomByDormitoryName(dormitoryName);
    }
    @RequestMapping("/getdormitoryinfor")
    @ResponseBody
    public PageInfo<User> getDormitoryInfor(String dormitoryName, String room, Integer currentPage, Integer pageSize){
        PageInfo<User> pageInfo =  dormitoryService.getDormitoryInfor(dormitoryName,room,currentPage,pageSize);
        return pageInfo;
    }
}
