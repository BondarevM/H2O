package com.example.computer_store.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Laptop extends Product {
    private int size;
}
