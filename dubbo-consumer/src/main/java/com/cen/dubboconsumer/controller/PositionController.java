package com.cen.dubboconsumer.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cen.dubboapi.entity.Position;
import com.cen.dubboapi.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Reference
    private PositionService positionService;
    @RequestMapping("/getposition")
    @ResponseBody
    public List<Position> getPosition(){
        return positionService.getPosition();
    }
}
