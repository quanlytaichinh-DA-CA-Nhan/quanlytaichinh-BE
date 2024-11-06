package com.example.quanlytaichinh.model.entity.notifications;


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
@Table(name = "notifications")
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String type; // VD: "Payment Reminder", "Goal Reminder"
    private String message;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status; // ENUM: Sent, Unread, Read

    private LocalDateTime createdAt;

}
