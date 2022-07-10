package com.example.projectmanagmentsystem.service.impl;

import com.example.projectmanagmentsystem.dto.ProjectRequestDTO;
import com.example.projectmanagmentsystem.entity.Project;
import com.example.projectmanagmentsystem.entity.Task;
import com.example.projectmanagmentsystem.entity.taskstatus.Status;
import com.example.projectmanagmentsystem.repository.ProjectRepository;
import com.example.projectmanagmentsystem.repository.TaskRepository;
import com.example.projectmanagmentsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public void createProject(ProjectRequestDTO requestDTO) {

        var project = Project.builder()
                .projectName(requestDTO.getProjectName())
                .build();
        projectRepository.save(project);

        List<Task> tasks = requestDTO.getTasks().stream()
                .map(taskDTO->Task.builder()
                        .project(project)
                        .taskName(taskDTO.getTaskName())
                        .daysToComplete(taskDTO.getDaysToComplete())
                        .status(Status.TODO)
                        .build())
                .toList();
        taskRepository.saveAll(tasks);


    }

    @Override
    public List<Project> getAllProjects(int page) {
        Pageable pageable =  PageRequest.of(page,10);

        return projectRepository.findAll(pageable).getContent();

    }
}
