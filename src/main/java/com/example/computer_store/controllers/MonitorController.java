package com.example.computer_store.controllers;

import com.example.computer_store.models.Monitor;
import com.example.computer_store.services.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/monitor")
@RestController
public class MonitorController {
    private final MonitorService monitorService;

    @Autowired
    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping
    public List<Monitor> getAllMonitors() {
        return monitorService.getAllMonitors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monitor> getMonitorById(@PathVariable Integer id) {
        return ResponseEntity.ok(monitorService.getMonitorById(id));
    }

    @PostMapping
    public ResponseEntity<String> addMonitor(@RequestBody Monitor monitor) {
        monitorService.addMonitor(monitor);
        return ResponseEntity.created(URI.create("/api/monitor")).body("Monitor created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monitor> updateMonitor(@PathVariable Integer id, @RequestBody Monitor monitorDetails) {
        Monitor updatedMonitor = monitorService.updateMonitor(id, monitorDetails);
        return ResponseEntity.ok(updatedMonitor);
    }
}
