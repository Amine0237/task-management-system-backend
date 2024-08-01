package com.medamine.taskmanagement.service.dto;

import com.medamine.taskmanagement.domain.Project;
import com.medamine.taskmanagement.domain.Task;
import com.medamine.taskmanagement.domain.UserApp;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class TaskDTO implements Serializable {

    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Task.Status status;

    private LocalDateTime createdDate;

    private LocalDateTime dueDate;

    private Long userId;

    private Long projectId;

    public TaskDTO() {}

    public TaskDTO(
        Long id,
        String title,
        String description,
        Task.Status status,
        LocalDateTime createdDate,
        LocalDateTime dueDate,
        Long userId,
        Long projectId
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdDate = createdDate;
        this.dueDate = dueDate;
        this.userId = userId;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task.Status getStatus() {
        return status;
    }

    public void setStatus(Task.Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return (
            Objects.equals(id, taskDTO.id) &&
            Objects.equals(title, taskDTO.title) &&
            Objects.equals(description, taskDTO.description) &&
            status == taskDTO.status &&
            Objects.equals(createdDate, taskDTO.createdDate) &&
            Objects.equals(dueDate, taskDTO.dueDate) &&
            Objects.equals(userId, taskDTO.userId) &&
            Objects.equals(projectId, taskDTO.projectId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, status, createdDate, dueDate, userId, projectId);
    }

    @Override
    public String toString() {
        return (
            "TaskDTO{" +
            "id=" +
            id +
            ", title='" +
            title +
            '\'' +
            ", description='" +
            description +
            '\'' +
            ", status=" +
            status +
            ", createdDate=" +
            createdDate +
            ", dueDate=" +
            dueDate +
            ", userId=" +
            userId +
            ", projectId=" +
            projectId +
            '}'
        );
    }
}
