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
    public User getUserById(int id) {
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
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }
}
