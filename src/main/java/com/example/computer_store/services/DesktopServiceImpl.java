package com.example.computer_store.services;

import com.example.computer_store.exceptions.InvalidRequestException;
import com.example.computer_store.models.Desktop;
import com.example.computer_store.models.Product;
import com.example.computer_store.repositories.DesktopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DesktopServiceImpl implements ProductServiceInterface {
    private final DesktopRepository desktopRepository;

    @Autowired
    public DesktopServiceImpl(DesktopRepository desktopRepository) {
        this.desktopRepository = desktopRepository;
    }

    @Override
    public List<Product> getAll() {
        return desktopRepository.findAll().stream().map(p -> (Product) p).toList();
    }

    @Override
    public Desktop getById(Integer id) {
        Optional<Desktop> desktopOptional = desktopRepository.findById(id);

        if (desktopOptional.isPresent()) {
            return desktopOptional.get();
        } else {
            throw new InvalidRequestException("Desktop not found with id " + id);
        }
    }

    @Override
    @Transactional
    public void add(Product product) {
        desktopRepository.save((Desktop) product);
    }

    @Override
    @Transactional
    public Desktop update(Integer id, Product productDetails) {
        Desktop desktopDetails = (Desktop) productDetails;

        Desktop existingDesktop = desktopRepository.findById(id)
                .orElseThrow(() -> new InvalidRequestException("Desktop not found with id " + id));

        existingDesktop.setSerialNumber(desktopDetails.getSerialNumber());
        existingDesktop.setManufacturer(desktopDetails.getManufacturer());
        existingDesktop.setPrice(desktopDetails.getPrice());
        existingDesktop.setQuantity(desktopDetails.getQuantity());
        existingDesktop.setFormFactor(desktopDetails.getFormFactor());

        return desktopRepository.save(existingDesktop);
    }
}