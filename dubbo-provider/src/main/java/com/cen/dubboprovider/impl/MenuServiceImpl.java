package com.cen.dubboprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cen.dubboapi.entity.Menu;
import com.cen.dubboapi.service.MenuService;
import com.cen.dubboprovider.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getMenu() {
        return menuMapper.getMenu();
    }

    @Override
    public List<Menu> getSubMenu(int mid) {
        return menuMapper.getSubMenu(mid);
    }
}
