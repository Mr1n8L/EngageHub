package com.engagehub.api.repository;

import com.engagehub.api.model.AuthenticationSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationSessionRepository extends JpaRepository<AuthenticationSession, Long> {
    // Custom query methods if needed
}
