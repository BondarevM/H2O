package com.example.computer_store.services;

import com.example.computer_store.exceptions.InvalidRequestException;
import com.example.computer_store.models.HardDrive;
import com.example.computer_store.models.Product;
import com.example.computer_store.repositories.HardDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HardDriveServiceImpl implements ProductServiceInterface{
    private final HardDriveRepository hardDriveRepository;

    @Autowired
    public HardDriveServiceImpl(HardDriveRepository hardDriveRepository) {
        this.hardDriveRepository = hardDriveRepository;
    }
    @Override
    public List<Product> getAll() {
        return hardDriveRepository.findAll().stream().map(p -> (Product) p).toList();
    }

    @Override
    public HardDrive getById(Integer id) {
        Optional<HardDrive> hardDriveOptional = hardDriveRepository.findById(id);

        if (hardDriveOptional.isPresent()) {
            return hardDriveOptional.get();
        } else {
            throw new InvalidRequestException("Hard drive not found with id " + id);
        }
    }

    @Override
    @Transactional
    public void add(Product product) {
        hardDriveRepository.save((HardDrive) product);
    }

    @Override
    @Transactional
    public HardDrive update(Integer id, Product productDriveDetails) {
        HardDrive hardDriveDetails = (HardDrive) productDriveDetails;

        HardDrive existingHardDrive = hardDriveRepository.findById(id)
                .orElseThrow(() -> new InvalidRequestException("Hard drive not found with id " + id));

        existingHardDrive.setSerialNumber(hardDriveDetails.getSerialNumber());
        existingHardDrive.setManufacturer(hardDriveDetails.getManufacturer());
        existingHardDrive.setPrice(hardDriveDetails.getPrice());
        existingHardDrive.setQuantity(hardDriveDetails.getQuantity());
        existingHardDrive.setCapacity(hardDriveDetails.getCapacity());

        return hardDriveRepository.save(existingHardDrive);
    }
}