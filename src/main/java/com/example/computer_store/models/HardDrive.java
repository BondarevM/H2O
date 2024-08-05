package com.example.computer_store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Hard_drive")
public class HardDrive extends Product {
    private int capacity;
}
