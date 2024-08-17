package com.engagehub.api.repository;

import com.engagehub.api.model.AuthenticationSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthenticationSessionRepository extends JpaRepository<AuthenticationSession, Long> {
    List<AuthenticationSession> findByUserIdAndActive(Long userId, boolean active);
}
