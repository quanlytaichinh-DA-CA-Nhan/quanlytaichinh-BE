package com.example.quanlytaichinh.model.entity.budgets;

import com.example.quanlytaichinh.model.entity.users.User;
import jakarta.persistence.*;
import jdk.jfr.Category;

import java.time.LocalDateTime;

public class Budgets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Double monthlyLimit;

    @Enumerated(EnumType.STRING)
    private BudgetStatus status; // ENUM: Active, Expired

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
