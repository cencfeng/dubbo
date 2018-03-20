package com.cen.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    UserService userService;
    @RequestMapping("/login")
    public String login(User user){
        user = userService.getUser(user.getUsername());
        if(user != null){
            return "menu";
        }
        return "failed";
    }
}
