package com.medamine.taskmanagement.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToMany
    @JoinTable(name = "project_user", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserApp> users;

    @OneToMany(mappedBy = "project")
    private Set<Task> tasks;

    public Project(Long id, String name, String description, LocalDate startDate, LocalDate endDate, Set<UserApp> users, Set<Task> tasks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.users = users;
        this.tasks = tasks;
    }

    public Project() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Set<UserApp> getUsers() {
        return users;
    }

    public void setUsers(Set<UserApp> users) {
        this.users = users;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
