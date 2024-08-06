package com.example.computer_store.services;

import com.example.computer_store.models.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductServiceInterface {
    List<Product> getAll();

    Product getById(Integer id);

    @Transactional
    void add(Product monitor);

    @Transactional
    Product update(Integer id, Product productDetails);
}
