package com.cen.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cen.dubboapi.entity.Menu;
import com.cen.dubboapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Reference
    private MenuService menuService;
    @RequestMapping("/getmenu")
    @ResponseBody
    public List<Menu> getMenu(){
        List<Menu> list = menuService.getMenu();
        return list;
    }
    @RequestMapping("/getsubmenu")
    @ResponseBody
    public List<Menu> getSubMenu(int mid){
        List<Menu> list = menuService.getSubMenu(mid);
        return list;
    }
}
