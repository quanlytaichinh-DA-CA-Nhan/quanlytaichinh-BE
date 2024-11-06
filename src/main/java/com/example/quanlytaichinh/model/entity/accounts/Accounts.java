package com.example.quanlytaichinh.model.entity.accounts;


import com.example.quanlytaichinh.model.entity.users.AccountStatus;
import com.example.quanlytaichinh.model.entity.users.AccountType;
import com.example.quanlytaichinh.model.entity.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String accountName; // VD: "Tài khoản tiết kiệm học phí"

    @Enumerated(EnumType.STRING)
    private AccountType accountType; // ENUM: Savings, Checking, Investment

    private Double balance;
    private LocalDateTime createdAtAccount;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @PrePersist
    private void onCreate() {
        this.createdAtAccount = LocalDateTime.now();
    }
}
