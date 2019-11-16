package com.store.system.mapper;

import com.store.system.entity.User;
import org.springframework.stereotype.Component;

@Component(value = "userMapper")
public interface UserMapper {
    User getUser(String id);

    void createUser(User user);

    User getUserByNameAndPassword(String name, String password);

    User update(User user);
}
