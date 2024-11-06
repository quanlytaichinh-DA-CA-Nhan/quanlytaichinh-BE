package com.example.quanlytaichinh.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    private String name; // VD: "Ăn uống", "Đi lại"

    @Enumerated(EnumType.STRING)
    private CategoryType type; // ENUM: Income, Expense
}

