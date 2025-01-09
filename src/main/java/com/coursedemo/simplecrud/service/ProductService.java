package com.coursedemo.simplecrud.service;

import com.coursedemo.simplecrud.model.product.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);

    Product update(Product product);
    Product createRandmProduct();
}
