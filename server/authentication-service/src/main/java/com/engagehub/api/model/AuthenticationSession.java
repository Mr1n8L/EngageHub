package com.engagehub.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "authentication_sessions")
public class AuthenticationSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    private String device;

    private String location;

    private boolean active;
}
