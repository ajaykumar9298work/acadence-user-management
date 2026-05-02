package com.user_management.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_entity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private String userId;
    private String registerNumber;
    private String dateOfBirth;
    private String gender;
    private String classId;
    private String admissionDate;
    private boolean isActive;
}
