package com.engagehub.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "authentication_users")
public class AuthenticationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean emailVerified = false;
}
