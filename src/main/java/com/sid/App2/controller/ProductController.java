package com.sid.App2.controller;

import com.sid.App2.model.Product;
import com.sid.App2.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    Logger logger = LogManager.getLogger(ProductController.class);
    @Autowired
    ProductService service;
    @GetMapping("/products")
    public List<Product> getProducts(){
        logger.info("ProductController getProducts");
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        logger.info("ProductController getProductById {id}", id);
        return service.getProductById(id);
    }
    @PostMapping("/products")
    public void addProduct(@RequestBody Product p){
        logger.info("ProductController addProduct {p}", p);
        service.addProduct(p);
        logger.info("ProductController addProduct executed");
    }
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product p){
        logger.info("ProductController updateProduct {p}", p);
        service.updateProduct(p);
        logger.info("ProductController updateProduct executed");
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        logger.info("ProductController deleteProduct {id}", id);
        service.deleteProduct(id);
        logger.info("ProductController deleteProduct executed");
    }
}
