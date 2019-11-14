package com.store.system.entity;

import lombok.Data;

@Data
public class Client {
    private Integer id;
    private String name;
    private Integer type;
    private String contacts;
    private Integer concatPhone;
    private String address;
    private String mark;
}
