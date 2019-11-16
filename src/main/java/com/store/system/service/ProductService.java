package com.store.system.service;

import com.store.system.entity.Product;

import java.util.List;

public interface ProductService {
    void insertProduct(Product product);

    List<Product> findList();
}
