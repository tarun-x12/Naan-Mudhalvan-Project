package com.sivanitechtutes.customer_orders.controller;

import com.sivanitechtutes.customer_orders.enums.Role;
import com.sivanitechtutes.customer_orders.model.RegisterRequest;
import com.sivanitechtutes.customer_orders.model.User;
import com.sivanitechtutes.customer_orders.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sivani
 */
@RestController
@RequestMapping("/api/auth")
public class RegisterController {

    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request) {
        log.info("register user invoked : {}" , request);
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Hash password
        user.setRole(Role.valueOf(request.getRole().toUpperCase())); // Ensure uppercase role

        userRepository.save(user);
        return "User registered successfully!";
    }
}
