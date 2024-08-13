package com.engagehub.api.dgs;


import com.engagehub.crm.authentication.model.User;
import com.engagehub.crm.authentication.repository.UserRepository;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@DgsComponent
public class AuthDataFetcher {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @DgsMutation
    public String registerUser(@InputArgument String email, @InputArgument String password) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        // Send a confirmation email (not implemented in this example)

        return "User registered successfully. Please check your email for confirmation.";
    }

    // Other mutations and queries will be implemented as needed
}
