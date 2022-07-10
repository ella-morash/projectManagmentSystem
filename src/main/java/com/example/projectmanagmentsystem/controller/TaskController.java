package com.example.projectmanagmentsystem.controller;

import com.example.projectmanagmentsystem.dto.TaskRequestDTO;
import com.example.projectmanagmentsystem.entity.Task;
import com.example.projectmanagmentsystem.entity.taskstatus.Status;
import com.example.projectmanagmentsystem.service.TaskService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(path = "/api/tasks/push_forward/{id}")
    public void pushTasksForward(@PathVariable(name = "id") Long id) {
        taskService.pushTasksForward(id);
    }

    @PostMapping(path = "/api/tasks/push_backward/{id}")
    public void pushTasksBackward(@PathVariable(name = "id") Long id) {
        taskService.pushTasksBackward(id);
    }

    @GetMapping(path = "/api/tasks")
    public List<Task> getAllTasks(@JsonProperty("status") @RequestParam(name="status") String status) {
        return taskService.getAllTasks(status);
    }

    @GetMapping(path = "/api/tasks/abandoned")
    public List<Task> getAllLostTasks() {
        return taskService.getAllLostTasks();
    }
}
