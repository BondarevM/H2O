package com.example.computer_store.services;

import com.example.computer_store.exceptions.InvalidRequestException;
import com.example.computer_store.models.Monitor;
import com.example.computer_store.models.Product;
import com.example.computer_store.repositories.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorServiceImpl implements ProductServiceInterface {
    private final MonitorRepository monitorRepository;

    @Autowired
    public MonitorServiceImpl(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @Override
    public List<Product> getAll() {
        return monitorRepository.findAll().stream().map(p -> (Product) p).toList();
    }

    @Override
    public Product getById(Integer id) {
        Optional<Monitor> optionalMonitor = monitorRepository.findById(id);

        if (optionalMonitor.isPresent()) {
            return optionalMonitor.get();
        } else {
            throw new InvalidRequestException("Monitor not found with id " + id);
        }
    }

    @Override
    @Transactional
    public void add(Product product) {
        monitorRepository.save((Monitor) product);
    }

    @Override
    @Transactional
    public Monitor update(Integer id, Product productDetailsDetails) {
        Monitor monitorDetailsDetails = (Monitor) productDetailsDetails;

        Monitor existingMonitor = monitorRepository.findById(id)
                .orElseThrow(() -> new InvalidRequestException("Monitor not found with id " + id));

        existingMonitor.setSerialNumber(monitorDetailsDetails.getSerialNumber());
        existingMonitor.setManufacturer(monitorDetailsDetails.getManufacturer());
        existingMonitor.setPrice(monitorDetailsDetails.getPrice());
        existingMonitor.setQuantity(monitorDetailsDetails.getQuantity());
        existingMonitor.setDiagonal(monitorDetailsDetails.getDiagonal());

        return monitorRepository.save(existingMonitor);
    }
}