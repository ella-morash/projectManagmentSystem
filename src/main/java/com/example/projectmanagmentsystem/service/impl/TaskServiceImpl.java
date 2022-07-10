package com.example.projectmanagmentsystem.service.impl;

import com.example.projectmanagmentsystem.entity.Task;
import com.example.projectmanagmentsystem.entity.taskstatus.Status;
import com.example.projectmanagmentsystem.repository.TaskRepository;
import com.example.projectmanagmentsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public void pushTasksForward(Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No task with %s id",id)));
        Status status = task.getStatus();
        switch (status) {
            case TODO -> task.setStatus(Status.IN_PROGRESS);
            case IN_PROGRESS -> task.setStatus(Status.DONE);
        }
        taskRepository.save(task);
    }

    @Override
    public void pushTasksBackward(Long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No task with %s id",id)));
        Status status = task.getStatus();
        switch (status) {
            case DONE -> task.setStatus(Status.IN_PROGRESS);
            case IN_PROGRESS -> task.setStatus(Status.TODO);
        }
        taskRepository.save(task);

    }

    @Override
    public List<Task> getAllTasks(String status) {
        Status status1 = Status.findByExternalStatusId(status);
        var tasks = taskRepository.findAllByStatus(status1);
       return !tasks.isEmpty() ? tasks : new ArrayList<>();

    }

    @Override
    public List<Task> getAllLostTasks() {
        var tasks = taskRepository.findAll();
        var abandoned = tasks.stream()
                .filter(task-> task.getStatus().equals(Status.IN_PROGRESS) && DAYS.between(LocalDate.now(),task.getUpdatedOn()) > 7).toList();
        return !abandoned.isEmpty() ? abandoned : new ArrayList<>();
    }
}
