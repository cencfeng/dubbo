package com.cen.dubboprovider.provider;

import com.cen.dubboapi.entity.User;
import com.cen.dubboprovider.mapper.DormitoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderTest {
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Test
    public void getDormitory(){
        List<User> userList = dormitoryMapper.getDormitoryInfor("A","0");
        for (User user:userList) {
            System.out.println(user.getAccount());
        }
    }
}
