package com.example.quanlytaichinh.model.entity.savings_goals;


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
@Table(name = "savings_goals")
public class Savings_goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double targetAmount;
    private Double currentAmount;
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private GoalStatus status; // ENUM: InProgress, Achieved, Cancelled

    private LocalDateTime createdAt;

}
