package com.example.quanlytaichinh.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "payment_methods")
public class Payment_methods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @Enumerated(EnumType.STRING)
    private PaymentMethodType type; // ENUM: CREDIT_CARD, BANK_TRANSFER, PAYPAL, CASH


    private String description;
}
