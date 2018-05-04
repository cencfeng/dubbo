package com.cen.dubboconsumer.test;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboConsumerTest {
    private UserService userService;
    @Test
    public void testgetConsumerRef(){
        ApplicationContext dubbo_cusumer = new ClassPathXmlApplicationContext("classpath:/dubbo/dubbo-consumer.xml");
        userService = (UserService)dubbo_cusumer.getBean("userService");
        User user = userService.getUserByAccount("20026080");
        System.out.println(user.getAccount());
    }
}


