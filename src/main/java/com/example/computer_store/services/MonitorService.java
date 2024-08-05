package com.example.computer_store.services;

import com.example.computer_store.exceptions.InvalidRequestException;
import com.example.computer_store.models.Monitor;
import com.example.computer_store.repositories.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorService {
    MonitorRepository monitorRepository;

    @Autowired
    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public List<Monitor> getAllMonitors() {
        return monitorRepository.findAll();
    }

    public Monitor getMonitorById(Integer id) {
        Optional<Monitor> optionalMonitor = monitorRepository.findById(id);

        if (optionalMonitor.isPresent()) {
            return optionalMonitor.get();
        } else {
            throw new InvalidRequestException("Monitor not found with id " + id);
        }
    }

    @Transactional
    public void addMonitor(Monitor monitor) {
        monitorRepository.save(monitor);
    }

    @Transactional
    public Monitor updateMonitor(Integer id, Monitor monitorDetails) {
        Monitor existingMonitor = monitorRepository.findById(id)
                .orElseThrow(() -> new InvalidRequestException("Monitor not found with id " + id));

        existingMonitor.setSerialNumber(monitorDetails.getSerialNumber());
        existingMonitor.setManufacturer(monitorDetails.getManufacturer());
        existingMonitor.setPrice(monitorDetails.getPrice());
        existingMonitor.setQuantity(monitorDetails.getQuantity());
        existingMonitor.setDiagonal(monitorDetails.getDiagonal());

        return monitorRepository.save(existingMonitor);
    }
}