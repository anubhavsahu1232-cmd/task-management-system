package com.taskmanager.dto;

import com.taskmanager.model.TaskPriority;
import com.taskmanager.model.TaskStatus;

import java.time.LocalDate;

public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDate dueDate;

    public TaskResponse() {
    }

    public TaskResponse(
            Long id,
            String title,
            String description,
            TaskStatus status,
            TaskPriority priority,
            LocalDate dueDate) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}