package com.example.quanlytaichinh.model.entity.debts;

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
@Table(name = "debts")
public class Debts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double amount;
    private Double interestRate;
    private Double remainingBalance;
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private DebtStatus status; // ENUM: InProgress, PaidOff, Overdue

    private Double monthlyPayment;
    private String description;
    private LocalDateTime createdAt;
}
