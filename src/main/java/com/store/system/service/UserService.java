package com.store.system.service;

import com.store.system.entity.User;

public interface UserService {
    User getUser(String id);

    void createUser(User user);
}
