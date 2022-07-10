package com.example.projectmanagmentsystem.dto;

import com.example.projectmanagmentsystem.entity.taskstatus.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class TaskResponseDTO {
    private String taskName;
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private int daysToComplete;
    private Status status;
}
