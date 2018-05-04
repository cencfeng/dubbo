package com.cen.dubboprovider.mapper;

import com.cen.dubboapi.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    List<Dept> getDept();
}
