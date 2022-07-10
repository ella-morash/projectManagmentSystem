package com.example.projectmanagmentsystem.repository;

import com.example.projectmanagmentsystem.entity.Project;
import com.example.projectmanagmentsystem.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;



public interface ProjectRepository extends JpaRepository<Project,Long> {

    @NonNull
    Page<Project> findAll(Pageable pageable);

    Page<Task> findAllByProjectName(String name, Pageable pageable);


}
