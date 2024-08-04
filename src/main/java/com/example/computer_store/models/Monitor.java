package com.example.computer_store.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Monitor extends Product {
    private double diagonal;
}
