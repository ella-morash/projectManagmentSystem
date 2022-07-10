package com.example.projectmanagmentsystem.service;

import com.example.projectmanagmentsystem.dto.ProjectRequestDTO;
import com.example.projectmanagmentsystem.entity.Project;

import java.util.List;

public interface ProjectService {

    void createProject(ProjectRequestDTO requestDTO);

    List<Project> getAllProjects(int page);
}
