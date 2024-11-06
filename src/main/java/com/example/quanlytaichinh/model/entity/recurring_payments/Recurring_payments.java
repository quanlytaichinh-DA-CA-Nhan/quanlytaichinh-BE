package com.example.quanlytaichinh.model.entity.recurring_payments;


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
@Table(name = "recurring_payments")
public class Recurring_payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentFrequency frequency;

    private LocalDateTime nextPaymentDate;
    private String description;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
}
