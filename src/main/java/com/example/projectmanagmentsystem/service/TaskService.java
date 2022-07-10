package com.example.projectmanagmentsystem.service;

import com.example.projectmanagmentsystem.entity.Task;
import com.example.projectmanagmentsystem.entity.taskstatus.Status;

import java.util.List;

public interface TaskService {
    void pushTasksForward(Long id);

    void pushTasksBackward(Long id);

    List<Task> getAllTasks(String status);

    List<Task> getAllLostTasks();
}
