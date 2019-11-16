package com.store.system.mapper;

import com.store.system.entity.User;
import org.springframework.stereotype.Component;

@Component(value = "userMapper")
public interface UserMapper {
    User getUser(int id);

    void createUser(User user);

    User getUserByNameAndPassword(String name, String password);

    void update(User user);

    void delete(int id);
}
