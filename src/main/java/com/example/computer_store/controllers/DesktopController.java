package com.example.computer_store.controllers;

import com.example.computer_store.models.Desktop;
import com.example.computer_store.models.Product;
import com.example.computer_store.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/desktop")
@RestController
public class DesktopController {
    private final ProductServiceInterface service;

    @Autowired
    public DesktopController(ProductServiceInterface desktopServiceImpl) {
        this.service = desktopServiceImpl;
    }
    @GetMapping
    public List<Product> getAllDesktops(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getDesktopById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> addDesktop(@RequestBody Desktop desktop){
        service.add(desktop);
        return ResponseEntity.created(URI.create("/api/desktop")).body("Desktop created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateDesktop(@PathVariable Integer id, @RequestBody Desktop desktopDetails) {
        Product updatedProduct = service.update(id, desktopDetails);
        return ResponseEntity.ok(updatedProduct);
    }
}
