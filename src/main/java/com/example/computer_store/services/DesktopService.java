package com.example.computer_store.services;

import com.example.computer_store.exceptions.InvalidRequestException;
import com.example.computer_store.models.Desktop;
import com.example.computer_store.repositories.DesktopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DesktopService {
    private DesktopRepository desktopRepository;

    @Autowired
    public DesktopService(DesktopRepository desktopRepository) {
        this.desktopRepository = desktopRepository;
    }

    public List<Desktop> getAllDesktops(){
        return desktopRepository.findAll();
    }

    public Desktop getDesktopById(Integer id){
        Optional<Desktop> desktopOptional = desktopRepository.findById(id);

        if (desktopOptional.isPresent()){
            return desktopOptional.get();
        } else {
            throw new InvalidRequestException("Desktop not found with id " + id);
        }
    }
    @Transactional
    public void addDesktop(Desktop desktop){
        desktopRepository.save(desktop);
    }

    public Desktop updateDesktop(Integer id, Desktop desktopDetails) {
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
