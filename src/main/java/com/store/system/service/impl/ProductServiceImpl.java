package com.store.system.service.impl;

import com.store.system.entity.Product;
import com.store.system.mapper.ProductMapper;
import com.store.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }

    @Override
    public List<Product> findList() {
        return productMapper.findProductList();
    }
}
