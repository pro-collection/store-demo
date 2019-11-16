package com.store.system.service;

import com.store.system.entity.User;

public interface UserService {
    User getUserById(String id);

    void createUser(User user);

    User getUser(String name, String password);

    void update(User user);
}
