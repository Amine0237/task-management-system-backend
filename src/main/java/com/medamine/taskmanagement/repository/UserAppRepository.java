package com.medamine.taskmanagement.repository;

import com.medamine.taskmanagement.domain.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {}
