package com.example.projectmanagmentsystem.dto;

import com.example.projectmanagmentsystem.entity.taskstatus.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class TaskRequestDTO {


    @NotBlank(message = "field should not be empty")
    @Length(min=5,max=30,message = "invalid length")
    private String taskName;
    @NotNull(message = "field can not be null")
    @Length(max=365, message = "days range should be between 0 and 365")
    private int daysToComplete;

}
