package com.medamine.taskmanagement.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdDate;

    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserApp user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Task(
        String title,
        String description,
        Status status,
        LocalDateTime createdDate,
        LocalDateTime dueDate,
        UserApp user,
        Project project
    ) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdDate = createdDate;
        this.dueDate = dueDate;
        this.user = user;
        this.project = project;
    }

    public Task() {}

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public UserApp getUser() {
        return user;
    }

    public void setUser(UserApp user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED,
    }
}
