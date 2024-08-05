package com.example.computer_store.repositories;

import com.example.computer_store.models.HardDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDriveRepository extends JpaRepository<HardDrive, Integer> {
}
