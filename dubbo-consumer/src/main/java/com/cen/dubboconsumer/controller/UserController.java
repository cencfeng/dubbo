package com.cen.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cen.dubboapi.entity.Login;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes("login")
public class UserController {
    @Reference
    private UserService userService;
    @RequestMapping("/login")
    public String login(Login login){
        login = userService.getUser(login);
        if(login != null){
            return "menu";
        }
        return "failed";
    }
    @RequestMapping("/getuserbyname")
    @ResponseBody
    public User getUserByName(@ModelAttribute("login") Login login){
        User user = userService.getUserByName(login.getAccount());
        return user;
    }
}
