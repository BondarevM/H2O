package com.example.computer_store.controllers;

import com.example.computer_store.models.HardDrive;
import com.example.computer_store.models.Product;
import com.example.computer_store.services.HardDriveServiceImpl;
import com.example.computer_store.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/hard-drive")
@RestController
public class HardDriveController {

    private final ProductServiceInterface service;

    @Autowired
    public HardDriveController(ProductServiceInterface hardDriveServiceImpl) {
        this.service = hardDriveServiceImpl;
    }

    @GetMapping
    public List<Product> getAllHardDrives() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getHardDriveById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> addHardDrive(@RequestBody HardDrive hardDrive) {
        service.add(hardDrive);
        return ResponseEntity.created(URI.create("/api/hard-drive")).body("Hard drive created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateHardDrive(@PathVariable Integer id, @RequestBody HardDrive hardDriveDetails) {
        Product updatedProduct = service.update(id, hardDriveDetails);
        return ResponseEntity.ok(updatedProduct);
    }
}
