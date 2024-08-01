package com.medamine.taskmanagement.service;

import com.medamine.taskmanagement.domain.Project;
import com.medamine.taskmanagement.domain.Task;
import com.medamine.taskmanagement.domain.UserApp;
import com.medamine.taskmanagement.repository.ProjectRepository;
import com.medamine.taskmanagement.repository.TaskRepository;
import com.medamine.taskmanagement.repository.UserAppRepository;
import com.medamine.taskmanagement.repository.UserRepository;
import com.medamine.taskmanagement.service.dto.TaskDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserAppRepository userAppRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, UserAppRepository userAppRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.userAppRepository = userAppRepository;
        this.projectRepository = projectRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task save(TaskDTO taskDTO) {
        return taskRepository.save(toEntity(taskDTO));
    }

    public Task toEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setCreatedDate(taskDTO.getCreatedDate());
        task.setDueDate(taskDTO.getDueDate());

        Optional<UserApp> userApp = userAppRepository.findById(taskDTO.getUserId());
        userApp.ifPresent(task::setUser);

        Optional<Project> project = projectRepository.findById(taskDTO.getProjectId());
        project.ifPresent(task::setProject);

        return task;
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
