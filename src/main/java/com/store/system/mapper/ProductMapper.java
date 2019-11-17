package com.store.system.mapper;

import com.store.system.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "productMapper")
public interface ProductMapper {
    List<Product> findProductList();

    void insertProduct(Product product);

    void removeProduct(int id);

    void updateList(Product product);
}
