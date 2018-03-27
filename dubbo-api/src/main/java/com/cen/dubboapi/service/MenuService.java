package com.cen.dubboapi.service;

import com.cen.dubboapi.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenu();
    List<Menu> getSubMenu(int mid);
}
