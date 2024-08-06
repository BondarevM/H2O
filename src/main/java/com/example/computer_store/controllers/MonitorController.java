package com.example.computer_store.controllers;

import com.example.computer_store.models.Monitor;
import com.example.computer_store.models.Product;
import com.example.computer_store.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/monitor")
@RestController
public class MonitorController {
    private final ProductServiceInterface service;

    @Autowired
    public MonitorController(ProductServiceInterface monitorServiceImpl) {
        this.service = monitorServiceImpl;
    }

    @GetMapping
    public List<Product> getAllMonitors() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getMonitorById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> addMonitor(@RequestBody Monitor monitor) {
        service.add(monitor);
        return ResponseEntity.created(URI.create("/api/monitor")).body("Monitor created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateMonitor(@PathVariable Integer id, @RequestBody Monitor monitorDetails) {
        Product updatedProduct = service.update(id, monitorDetails);
        return ResponseEntity.ok(updatedProduct);
    }
}
