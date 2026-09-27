# ✅ Task Management System — Backend

A secure **REST API backend** for managing personal tasks using **Java, Spring Boot, MySQL, and JWT authentication**.

## ✨ Features

- 👤 User registration and authentication
- 🔐 BCrypt password hashing
- 🎫 JWT-based authentication
- 🛡️ Protected REST APIs
- ➕ Create, view, update, and delete tasks
- 📊 Task status and priority management
- 📅 Due-date validation
- ⚠️ Global exception handling
- 📚 Swagger / OpenAPI documentation
- 🗄️ MySQL integration

## 🧰 Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Backend language |
| Spring Boot | Application framework |
| Spring Security | Authentication & authorization |
| JWT | Stateless authentication |
| Spring Data JPA | Data access |
| Hibernate | ORM |
| MySQL | Database |
| Maven | Build management |
| Swagger / OpenAPI | API documentation |

## 🏗️ Architecture

```text
React Frontend
      │
      │ HTTP + JSON
      ▼
Spring Boot REST API
      │
      ├── Controller
      ├── Service
      ├── Repository
      ├── Security / JWT
      └── Exception Handler
              │
              ▼
            MySQL
```

## 📁 Package Structure

```text
src/main/java/com/taskmanager
├── config
├── controller
├── dto
├── exception
├── model
├── repository
└── service
```

## 🚀 Getting Started

```bash
git clone https://github.com/anubhavsahu1232-cmd/task-management-system.git
cd task-management-system
mvn spring-boot:run
```

Configure the MySQL connection and JWT settings before running.

> Never commit passwords, tokens, or production credentials.

## 🌐 Live Demo

[![🚀 LIVE DEMO](https://img.shields.io/badge/🚀%20LIVE%20DEMO-2563EB?style=for-the-badge)](https://task-management-frontend-fpzp.onrender.com)

**Live URL:** https://task-management-frontend-fpzp.onrender.com

## 🔗 Frontend Source Code

https://github.com/anubhavsahu1232-cmd/task-management-frontend

## 📌 Learning Outcomes

- REST API development
- JWT authentication and authorization
- Layered Spring Boot architecture
- JPA/Hibernate database integration
- Validation and exception handling
- Swagger/OpenAPI documentation
