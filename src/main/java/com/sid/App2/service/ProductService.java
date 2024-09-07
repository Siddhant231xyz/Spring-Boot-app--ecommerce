package com.sid.App2.service;

import com.sid.App2.model.Product;
import com.sid.App2.repository.ProductRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductService {
    Logger logger = LogManager.getLogger(ProductService.class);
    @Autowired
    ProductRepo repo;
//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101, "Iphone", 500),
//            new Product(102, "Camera", 300)));
    public List<Product> getProducts() {
        logger.info("ProductService getProducts");
        return repo.findAll();
    }

    public Product getProductById(int id) {
        logger.info("ProductService getProductById {id}", id);
        return repo.findById(id).orElse(new Product());
    }

    public void addProduct(Product p){
        logger.info("ProductService addProduct {p}", p);
        repo.save(p);
        logger.info("ProductService addProduct execution completed of {p}", p);
    }

    public void updateProduct(Product p) {
        logger.info("ProductService updateProduct {p}", p);
        repo.save(p);
        logger.info("ProductService updateProduct execution completed of {p}", p);


    }

    public void deleteProduct(int id) {
        logger.info("ProductService deleteProduct {id}", id);
        repo.deleteById(id);
        logger.info("ProductService deleteProduct execution completed");

    }
}
