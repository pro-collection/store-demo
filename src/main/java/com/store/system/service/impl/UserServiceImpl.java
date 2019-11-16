package com.store.system.service.impl;

import com.store.system.entity.User;
import com.store.system.mapper.UserMapper;
import com.store.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        return userMapper.getUser(id);
    }

    @Override
    public void createUser(User user) {
        userMapper.createUser(user);
    }

    @Override
    public User getUser(String name, String password) {
        return userMapper.getUserByNameAndPassword(name, password);
    }

    @Override
    public User update(User user) {
        return userMapper.update(user);
    }
}
