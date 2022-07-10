package com.example.projectmanagmentsystem.controller;

import com.example.projectmanagmentsystem.dto.ProjectRequestDTO;
import com.example.projectmanagmentsystem.entity.Project;
import com.example.projectmanagmentsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(path = "/api/project")
    public void createProject(@Valid @RequestBody ProjectRequestDTO requestDTO) {

        projectService.createProject(requestDTO);
    }

    @GetMapping(path = "/api/project") // make it return map project->tasks
    public List<Project> getAllProjects(@RequestParam(name = "page")int page) {
        return projectService.getAllProjects(page);
    }

}
