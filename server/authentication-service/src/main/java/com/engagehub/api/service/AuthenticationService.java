package com.engagehub.api.service;

import com.engagehub.api.model.AuthenticationUser;
import com.engagehub.api.model.AuthenticationSession;
import com.engagehub.api.repository.AuthenticationUserRepository;
import com.engagehub.api.repository.AuthenticationSessionRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationUserRepository userRepository;
    private final AuthenticationSessionRepository sessionRepository;

    public AuthenticationService(AuthenticationUserRepository userRepository,
                                 AuthenticationSessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public AuthenticationUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public AuthenticationSession getSessionById(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }

    // Implement other business logic methods as needed
}
