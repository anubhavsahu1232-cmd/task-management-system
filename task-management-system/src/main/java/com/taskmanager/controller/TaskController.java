package com.taskmanager.controller;

import com.taskmanager.dto.TaskRequest;
import com.taskmanager.dto.TaskResponse;
import com.taskmanager.service.TaskService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@SecurityRequirement(name = "bearerAuth")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(
            @Valid @RequestBody TaskRequest request,
            Authentication authentication) {

        return new ResponseEntity<>(
                taskService.createTask(request, authentication),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getUserTasks(
            Authentication authentication) {

        return ResponseEntity.ok(
                taskService.getUserTasks(authentication)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(
            @PathVariable Long id,
            Authentication authentication) {

        return ResponseEntity.ok(
                taskService.getTaskById(id, authentication)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request,
            Authentication authentication) {

        return ResponseEntity.ok(
                taskService.updateTask(
                        id,
                        request,
                        authentication
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(
            @PathVariable Long id,
            Authentication authentication) {

        taskService.deleteTask(id, authentication);

        return ResponseEntity.ok(
                "Task deleted successfully"
        );
    }
}