# Task Management System - Backend

A secure REST API backend for managing personal tasks using Spring Boot, MySQL and JWT authentication.

## 🚀 Features

- User registration
- Secure password hashing using BCrypt
- User login with JWT authentication
- JWT-based protected APIs
- Create, view, update and delete tasks
- User-specific task access
- Task status management
- Task priority management
- Due date validation
- Global exception handling
- Swagger/OpenAPI documentation
- MySQL database integration

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JWT
- Maven
- Swagger / OpenAPI

## 📁 Project Structure

```text
src/main/java/com/taskmanager
│
├── config
│   ├── JwtAuthenticationFilter.java
│   ├── OpenAPIConfig.java
│   ├── SecurityConfig.java
│   └── WebConfig.java
│
├── controller
│   ├── AuthController.java
│   ├── TaskController.java
│   └── UserController.java
│
├── dto
│   ├── LoginRequest.java
│   ├── LoginResponse.java
│   ├── TaskRequest.java
│   ├── TaskResponse.java
│   ├── UserRequest.java
│   └── UserResponse.java
│
├── exception
│   └── GlobalExceptionHandler.java
│
├── model
│   ├── Task.java
│   ├── TaskPriority.java
│   ├── TaskStatus.java
│   └── User.java
│
├── repository
│   ├── TaskRepository.java
│   └── UserRepository.java
│
└── service
    ├── AuthService.java
    ├── JwtService.java
    ├── TaskService.java
    └── UserService.java
