package com.example.computer_store.services;

import com.example.computer_store.exceptions.InvalidRequestException;
import com.example.computer_store.models.Laptop;
import com.example.computer_store.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(Integer id) {
        Optional<Laptop> laptopOptional = laptopRepository.findById(id);

        if (laptopOptional.isPresent()) {
            return laptopOptional.get();
        } else {
            throw new InvalidRequestException("Laptop not found with id " + id);
        }
    }

    @Transactional
    public void addLaptop(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    @Transactional
    public Laptop updateLaptop(Integer id, Laptop laptopDetails) {
        Laptop existingLaptop = laptopRepository.findById(id)
                .orElseThrow(() -> new InvalidRequestException("Laptop not found with id " + id));

        existingLaptop.setSerialNumber(laptopDetails.getSerialNumber());
        existingLaptop.setManufacturer(laptopDetails.getManufacturer());
        existingLaptop.setPrice(laptopDetails.getPrice());
        existingLaptop.setQuantity(laptopDetails.getQuantity());
        existingLaptop.setSize(laptopDetails.getSize());

        return laptopRepository.save(existingLaptop);
    }
}