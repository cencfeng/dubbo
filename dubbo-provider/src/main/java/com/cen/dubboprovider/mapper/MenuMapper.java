package com.cen.dubboprovider.mapper;

import com.cen.dubboapi.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> getMenu();
    List<Menu> getSubMenu(int mid);
}
