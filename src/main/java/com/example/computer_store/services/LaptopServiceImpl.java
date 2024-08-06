package com.example.computer_store.services;

import com.example.computer_store.exceptions.InvalidRequestException;
import com.example.computer_store.models.Laptop;
import com.example.computer_store.models.Product;
import com.example.computer_store.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements ProductServiceInterface {
    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    public List<Product> getAll() {
        return laptopRepository.findAll().stream().map(p -> (Product) p).toList();
    }

    @Override
    public Laptop getById(Integer id) {
        Optional<Laptop> laptopOptional = laptopRepository.findById(id);

        if (laptopOptional.isPresent()) {
            return laptopOptional.get();
        } else {
            throw new InvalidRequestException("Laptop not found with id " + id);
        }
    }
    @Override
    @Transactional
    public void add(Product product) {
        laptopRepository.save((Laptop) product);
    }

    @Override
    @Transactional
    public Laptop update(Integer id, Product productDetails) {
        Laptop laptopDetails = (Laptop) productDetails;

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