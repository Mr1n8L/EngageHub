package com.engagehub.api.repository;

import com.engagehub.api.model.AuthenticationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationUserRepository extends JpaRepository<AuthenticationUser, Long> {
    AuthenticationUser findByEmail(String email);
}
