package com.example.projectmanagmentsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ProjectResponseDTO {
           /* projectId: Long (system managed value)
projectName: String (not blank, length 5-30 chars)
createdOn: Datetime (system managed value)
updatedOn: Datetime (system managed value)
tasks: [
		taskId: Long
		taskName: String (not blank, length 5-30 chars)
		daysToComplete: int (not null, > 0, < 365)
		status: TODO, IN PROGRESS, DONE
		createdOn: Datetime (system managed value)
		updatedOn: Datetime (system managed value)
] */

    private long id;
    private String projectName;
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private List<TaskResponseDTO> tasks;
}
