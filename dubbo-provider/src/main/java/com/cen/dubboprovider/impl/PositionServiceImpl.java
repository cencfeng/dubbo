package com.cen.dubboprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cen.dubboapi.entity.Position;
import com.cen.dubboapi.service.PositionService;
import com.cen.dubboprovider.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;
    @Override
    public List<Position> getPosition() {
        return positionMapper.getPosition();
    }
}
