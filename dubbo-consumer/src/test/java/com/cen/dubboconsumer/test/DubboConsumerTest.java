package com.cen.dubboconsumer.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboConsumerTest {
    @Reference
    private UserService userService;
    @Test
    public void getUser(){
        User user = userService.getUser("20026080");
        System.out.println(user.getUsername()+user.getPassword());
    }
}
