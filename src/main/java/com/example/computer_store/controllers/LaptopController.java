package com.example.computer_store.controllers;

import com.example.computer_store.models.Laptop;
import com.example.computer_store.models.Product;
import com.example.computer_store.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/laptop")
@RestController
public class LaptopController {
    private final ProductServiceInterface service;

    @Autowired
    public LaptopController(ProductServiceInterface laptopServiceImpl) {
        this.service = laptopServiceImpl;
    }

    @GetMapping
    public List<Product> getAllLaptops() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getLaptopById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> addLaptop(@RequestBody Laptop laptop) {
        service.add(laptop);
        return ResponseEntity.created(URI.create("/api/laptop")).body("Laptop created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateLaptop(@PathVariable Integer id, @RequestBody Laptop laptopDetails) {
        Product updatedProduct = service.update(id, laptopDetails);
        return ResponseEntity.ok(updatedProduct);
    }
}
