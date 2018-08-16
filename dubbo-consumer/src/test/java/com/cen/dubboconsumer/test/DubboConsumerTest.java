package com.cen.dubboconsumer.test;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cen.dubboapi.entity.Costform;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.FormService;
import com.cen.dubboapi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboConsumerTest {
    //@Reference
    private UserService userService;
    private FormService formService;
//    @Test
//    public void testgetConsumerRef(){
//        ApplicationContext dubbo_cusumer = new ClassPathXmlApplicationContext("classpath:/dubbo/dubbo-consumer.xml");
//        userService = (UserService)dubbo_cusumer.getBean("userService");
//        User user = userService.getUserByAccount("20026080");
//        System.out.println(user.getAccount());
//    }
    @Test
    public void testGetSignSum(){
        ApplicationContext dubbo_cusumer = new ClassPathXmlApplicationContext("classpath:/dubbo/dubbo-consumer.xml");
        formService = (FormService) dubbo_cusumer.getBean("formService");
        List<Map<String,Object>> maplist = formService.getSignsum("1002002");
        for (Map<String, Object> map :maplist){
            System.out.println(map.get("formtype"));
            System.out.println(map.get("signsum"));
        }
    }
    @Test
    public void testGetPrform(){
        ApplicationContext dubbo_cusumer = new ClassPathXmlApplicationContext("classpath:/dubbo/dubbo-consumer.xml");
        formService = (FormService) dubbo_cusumer.getBean("formService");
        List<Costform> costformList = formService.getPrformInfor("S-PR-MIS18-002");
        for (Costform costform :costformList){
            System.out.println(costform.getFormcode());
        }
    }
}


