package com.example.projectmanagmentsystem.entity;


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
@Table(name = "project")
@EntityListeners(AuditingEntityListener.class)
public class Project {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "project_name")//(not blank, length 5-30 chars)
    private String projectName;
    @LastModifiedDate
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @CreatedDate
    @Column(name = "created_on")
    private LocalDateTime createdOn;




}
