package com.user_management.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teacher_entity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherId;
    private String userId;
    private String employeeId;
    private String department;
    private String joiningDate;
    private Boolean isActive;
}
