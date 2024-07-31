package com.medamine.taskmanagement.repository;

import com.medamine.taskmanagement.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {}
