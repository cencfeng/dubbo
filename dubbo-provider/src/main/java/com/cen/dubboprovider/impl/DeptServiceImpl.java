package com.cen.dubboprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cen.dubboapi.entity.Dept;
import com.cen.dubboapi.service.DeptService;
import com.cen.dubboprovider.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> getDept() {
        return deptMapper.getDept();
    }
}
