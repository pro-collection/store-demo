package com.store.system.entity;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private String specification;
    private double price;
    private int upperLimit;
    private int lowerLimit;
    private String url;
}
