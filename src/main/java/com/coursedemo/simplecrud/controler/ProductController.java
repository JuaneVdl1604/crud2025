package com.coursedemo.simplecrud.controler;

import com.coursedemo.simplecrud.model.product.Product;
import com.coursedemo.simplecrud.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {

    private final ProductServiceImpl productService;
    public ProductController(ProductServiceImpl productService) {

        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        try{
            Product newProduct = productService.save(product);
            log.info("New product created: {}", newProduct);
            return ResponseEntity.ok().body(newProduct);
        }catch(Exception e){
            log.error("Error while creating new product: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        try{
            List<Product> products = productService.findAll();
            log.info("All products retrieved: {}", products);
            return ResponseEntity.ok().body(products);
        }catch(Exception e){
            log.error("Error while creating new product: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        //return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        try{
            Product newProduct = productService.findById(id);
            log.info("Product found: {}", newProduct);
            return ResponseEntity.ok().body(newProduct);
        }catch(Exception e){
            log.error("Error while finding new product: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        //return productService.findById(id);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        try{
            Product newProduct = productService.update(product);;
            log.info("New product updated: {}", newProduct);
            return ResponseEntity.ok().body(newProduct);
        }catch(Exception e){
            log.error("Error while updating new product: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        //return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Boolean> deleteProduct(@PathVariable int id){
        try{
            productService.deleteById(id);
            log.info("New product updated: {}", id);
            return ResponseEntity.ok().body(true);
        }catch(Exception e){
            log.error("Error while updating new product: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
       // productService.deleteById(id);
    }

    @PostMapping("/random")
    public ResponseEntity<Product> createRandomProduct(){
        try{
            Product product = productService.createRandmProduct();
            log.info("New random product created: {}", product);
            return ResponseEntity.ok().body(product);
        }catch(Exception e){
            log.error("Error creating rdm product: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
