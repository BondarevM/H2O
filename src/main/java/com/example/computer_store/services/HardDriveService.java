package com.example.computer_store.services;

import com.example.computer_store.exceptions.InvalidRequestException;
import com.example.computer_store.models.HardDrive;
import com.example.computer_store.repositories.HardDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HardDriveService {
    private final HardDriveRepository hardDriveRepository;

    @Autowired
    public HardDriveService(HardDriveRepository hardDriveRepository) {
        this.hardDriveRepository = hardDriveRepository;
    }

    public List<HardDrive> getAllHardDrivers() {
        return hardDriveRepository.findAll();
    }

    public HardDrive getHardDriveById(Integer id) {
        Optional<HardDrive> hardDriveOptional = hardDriveRepository.findById(id);

        if (hardDriveOptional.isPresent()) {
            return hardDriveOptional.get();
        } else {
            throw new InvalidRequestException("Hard drive not found with id " + id);
        }
    }

    @Transactional
    public void addHardDrive(HardDrive hardDrive) {
        hardDriveRepository.save(hardDrive);
    }

    @Transactional
    public HardDrive updateHardDrive(Integer id, HardDrive hardDriveDetails) {
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