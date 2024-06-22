package com.project.quickeats.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Grocery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private String category;

    public Grocery() {
    }

    public Grocery(String itemName, String category) {
        this.itemName = itemName;
        this.category = category;
    }
}
