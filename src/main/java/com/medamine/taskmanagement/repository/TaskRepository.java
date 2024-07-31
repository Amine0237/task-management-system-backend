package com.medamine.taskmanagement.repository;

import com.medamine.taskmanagement.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}
