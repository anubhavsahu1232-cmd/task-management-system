package com.taskmanager.controller;

import com.taskmanager.dto.UserRequest;
import com.taskmanager.dto.UserResponse;
import com.taskmanager.model.User;
import com.taskmanager.repository.UserRepository;
import com.taskmanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(
            UserService userService,
            UserRepository userRepository) {

        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody UserRequest request) {

        return new ResponseEntity<>(
                userService.createUser(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {

        return ResponseEntity.ok(
                userService.getAllUsers()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                userService.getUserById(id)
        );
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getLoggedInUser(
            Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );

        UserResponse response = new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );

        return ResponseEntity.ok(response);
    }
}