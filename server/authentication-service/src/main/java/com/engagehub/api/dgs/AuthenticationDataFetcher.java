package com.engagehub.api.dgs;

import com.engagehub.api.model.AuthenticationUser;
import com.engagehub.api.repository.AuthenticationUserRepository;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@DgsComponent
public class AuthenticationDataFetcher {

    @Autowired
    private AuthenticationUserRepository authenticationUserRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @DgsMutation
    public String registerUser(@InputArgument String email, @InputArgument String password) {
        Optional<AuthenticationUser> existingUser = authenticationUserRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        AuthenticationUser user = new AuthenticationUser();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        authenticationUserRepository.save(user);

        return "User registered successfully. Please check your email for confirmation.";
    }

    // Additional mutations and queries can be implemented as needed
}
