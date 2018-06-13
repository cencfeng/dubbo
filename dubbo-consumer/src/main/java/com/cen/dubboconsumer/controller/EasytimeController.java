package com.cen.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cen.dubboapi.entity.Article;
import com.cen.dubboapi.service.EasyTimeService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/easytime")
public class EasytimeController {
    @Reference
    private EasyTimeService easytimeService;
    @RequestMapping("/getjoke")
    @ResponseBody
    public PageInfo<Article> getJoke(Integer currentPage, Integer pageSize){
        PageInfo<Article> pageInfo =  easytimeService.getJoke(currentPage, pageSize);
        return pageInfo;
    }
    @RequestMapping("/invokpython")
    @ResponseBody
    public void invokpython(){
        easytimeService.invokPython();
    }
}