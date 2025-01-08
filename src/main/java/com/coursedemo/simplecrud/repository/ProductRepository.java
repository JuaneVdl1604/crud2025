package com.coursedemo.simplecrud.repository;

import com.coursedemo.simplecrud.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class ProductRepository {

    public List<Product> products = new ArrayList<>();

    public List<Product> findAll(){ return products; }

    public Product findById(int id){

        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst().orElseThrow();
    }
    public Product save(Product product){
        products.add(product);
        return product;
    }

    public Product update(Product newProduct){
        if(newProduct != null) {
            int index = products.stream().filter(
                    product -> product.equals(newProduct)
            ).findFirst().hashCode();

            Product updatedProduct = new Product();
            updatedProduct.setId(newProduct.getId());
            updatedProduct.setName(newProduct.getName());
            updatedProduct.setPrice(newProduct.getPrice());
            updatedProduct.setDescription(newProduct.getDescription());
            updatedProduct.setStock(newProduct.getStock());

            products.set(index, updatedProduct);
            return updatedProduct;
        } else {
            return null;
        }
    }

    public void deleteById(int id){
        products.removeIf(product -> product.getId() == id);
    }
}

