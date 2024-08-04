package com.example.computer_store.models;

import com.example.computer_store.models.Product;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Laptop extends Product {
    private int size;
}
