package com.example.projectmanagmentsystem.repository;

import com.example.projectmanagmentsystem.entity.Task;
import com.example.projectmanagmentsystem.entity.taskstatus.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {


    List<Task> findAllByStatus(Status status);
}
