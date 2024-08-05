package com.example.computer_store.controllers;

import com.example.computer_store.models.HardDrive;
import com.example.computer_store.services.HardDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/hard-drive")
@RestController
public class HardDriveController {

    HardDriveService hardDriveService;

    @Autowired
    public HardDriveController(HardDriveService hardDriveService) {
        this.hardDriveService = hardDriveService;
    }

    @GetMapping
    public List<HardDrive> getAllHardDrives() {
        return hardDriveService.getAllHardDrivers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardDrive> getHardDriveById(@PathVariable Integer id) {
        return ResponseEntity.ok(hardDriveService.getHardDriveById(id));
    }

    @PostMapping
    public ResponseEntity<String> addHardDrive(@RequestBody HardDrive hardDrive) {
        hardDriveService.addHardDrive(hardDrive);
        return ResponseEntity.created(URI.create("/api/hard-drive")).body("Hard drive created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardDrive> updateHardDrive(@PathVariable Integer id, @RequestBody HardDrive hardDriveDetails) {
        HardDrive updatedHardDrive = hardDriveService.updateHardDrive(id, hardDriveDetails);
        return ResponseEntity.ok(updatedHardDrive);
    }
}
