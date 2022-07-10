package com.example.projectmanagmentsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ProjectRequestDTO {

    @NotBlank(message = "field should not be empty")
    @Length(min=5,max=30,message = "invalid length")
    private String projectName;
    private List<TaskRequestDTO> tasks;

}
