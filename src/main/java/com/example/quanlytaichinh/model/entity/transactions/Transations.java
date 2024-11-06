package com.example.quanlytaichinh.model.entity.transactions;

import com.example.quanlytaichinh.model.entity.Categories;
import com.example.quanlytaichinh.model.entity.Payment_methods;
import com.example.quanlytaichinh.model.entity.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transactions")

public class Transations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private LocalDateTime transactionDate;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private Payment_methods paymentMethod;

}
