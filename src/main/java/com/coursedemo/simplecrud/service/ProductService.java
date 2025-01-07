package com.coursedemo.simplecrud.service;

import com.coursedemo.simplecrud.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
    Product update(Product product);
}
