package com.example.computer_store.controllers;

import com.example.computer_store.models.Desktop;
import com.example.computer_store.services.DesktopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/desktop")
@RestController
public class DesktopController {
    DesktopService desktopService;

    @Autowired
    public DesktopController(DesktopService desktopService) {
        this.desktopService = desktopService;
    }
    @GetMapping
    public List<Desktop> getAllDesktops(){
        return desktopService.getAllDesktops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Desktop> getDesktopById(@PathVariable Integer id){
        return ResponseEntity.ok(desktopService.getDesktopById(id));
    }

    @PostMapping
    public ResponseEntity<String> addDesktop(@RequestBody Desktop desktop){
        desktopService.addDesktop(desktop);
        return ResponseEntity.created(URI.create("/api/desktop")).body("Desktop created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Desktop> updateDesktop(@PathVariable Integer id, @RequestBody Desktop desktopDetails) {
        Desktop updatedDesktop = desktopService.updateDesktop(id, desktopDetails);
        return ResponseEntity.ok(updatedDesktop);
    }
}
