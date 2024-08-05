package com.example.computer_store.models;

import com.example.computer_store.models.enums.FormFactor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Desktop extends Product {

    @Enumerated(EnumType.STRING)
    @Column(name = "form_factor")
    FormFactor formFactor;
}
