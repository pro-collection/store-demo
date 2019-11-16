package com.store.system.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private int permissions;
    private String mark;
}
