package com.cen.dubboprovider.mapper;

import com.cen.dubboapi.entity.Position;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionMapper {
    List<Position> getPosition();
}

