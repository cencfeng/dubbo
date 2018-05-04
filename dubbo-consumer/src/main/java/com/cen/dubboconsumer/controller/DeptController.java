package com.cen.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cen.dubboapi.entity.Dept;
import com.cen.dubboapi.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Reference
    private DeptService deptService;
    @RequestMapping("/getdept")
    @ResponseBody
    public List<Dept> getDept(){
        return deptService.getDept();
    }
}
