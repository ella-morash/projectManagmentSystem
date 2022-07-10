package com.example.projectmanagmentsystem.entity;


import com.example.projectmanagmentsystem.entity.taskstatus.Status;
import com.example.projectmanagmentsystem.entity.taskstatus.StatusConverter;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "task")
@EntityListeners(AuditingEntityListener.class)
public class Task {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name")//(not blank, length 5-30 chars)
    private String taskName;

    @Column(name = "days_to_complete") //(not null, > 0, < 365)
    private int daysToComplete;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "status")
    @Convert(converter = StatusConverter.class)
    private Status status;

    @LastModifiedDate
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @CreatedDate
    @Column(name = "created_on")
    private LocalDateTime createdOn;

}
