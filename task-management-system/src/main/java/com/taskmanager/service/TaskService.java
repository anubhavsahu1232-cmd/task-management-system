package com.taskmanager.service;

import com.taskmanager.dto.TaskRequest;
import com.taskmanager.dto.TaskResponse;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;
import com.taskmanager.repository.TaskRepository;
import com.taskmanager.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(
            TaskRepository taskRepository,
            UserRepository userRepository) {

        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    private User getLoggedInUser(Authentication authentication) {

        String email = authentication.getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    private TaskResponse convertToResponse(Task task) {

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getDueDate()
        );
    }

    public TaskResponse createTask(
            TaskRequest request,
            Authentication authentication) {

        User user = getLoggedInUser(authentication);

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());
        task.setUser(user);

        Task savedTask = taskRepository.save(task);

        return convertToResponse(savedTask);
    }

    public List<TaskResponse> getUserTasks(
            Authentication authentication) {

        User user = getLoggedInUser(authentication);

        return taskRepository.findByUserId(user.getId())
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public TaskResponse getTaskById(
            Long id,
            Authentication authentication) {

        User user = getLoggedInUser(authentication);

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException(
                    "You are not allowed to access this task");
        }

        return convertToResponse(task);
    }

    public TaskResponse updateTask(
            Long id,
            TaskRequest request,
            Authentication authentication) {

        User user = getLoggedInUser(authentication);

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException(
                    "You are not allowed to access this task");
        }

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());

        Task updatedTask = taskRepository.save(task);

        return convertToResponse(updatedTask);
    }

    public void deleteTask(
            Long id,
            Authentication authentication) {

        User user = getLoggedInUser(authentication);

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException(
                    "You are not allowed to access this task");
        }

        taskRepository.delete(task);
    }
}