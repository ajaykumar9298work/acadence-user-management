package com.user_management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    private String studentId;
    private String userId;
    private String registerNumber;
    private Date dateOfBirth;
    private String gender;
    private String classId;
    private String admissionDate;
    private boolean isActive;
}
