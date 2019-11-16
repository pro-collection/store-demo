package com.store.system.service.impl;

import com.store.system.entity.User;
import com.store.system.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void createUser() {
        User user = new User();
        user.setName("宝批龙");
        user.setPassword("123123123");
        userService.createUser(user);
    }

    @Test
    void getUser() {
        User getUserInfo = userService.getUser("yanle", "yanle");
        System.out.println(getUserInfo.toString());
        Assert.assertNotNull(getUserInfo);
    }

    @Test
    void update() {
        User updateUser = new User();
        updateUser.setId(1);
        updateUser.setName("yanle3");
        updateUser.setPassword("yanle3");
        userService.update(updateUser);
    }
}