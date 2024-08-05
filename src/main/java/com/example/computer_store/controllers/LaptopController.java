package com.example.computer_store.controllers;

import com.example.computer_store.models.Laptop;
import com.example.computer_store.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/laptop")
@RestController
public class LaptopController {
    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable Integer id) {
        return ResponseEntity.ok(laptopService.getLaptopById(id));
    }

    @PostMapping
    public ResponseEntity<String> addLaptop(@RequestBody Laptop laptop) {
        laptopService.addLaptop(laptop);
        return ResponseEntity.created(URI.create("/api/laptop")).body("Laptop created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable Integer id, @RequestBody Laptop laptopDetails) {
        Laptop updatedLaptop = laptopService.updateLaptop(id, laptopDetails);
        return ResponseEntity.ok(updatedLaptop);
    }
}
