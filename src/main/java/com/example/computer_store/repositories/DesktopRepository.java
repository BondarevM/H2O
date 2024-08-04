package com.example.computer_store.repositories;

import com.example.computer_store.models.Desktop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesktopRepository extends JpaRepository<Desktop, Integer> {
}
