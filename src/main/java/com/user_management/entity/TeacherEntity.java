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
public class TeacherEntity {
    private String teacherId;
    private String userId;
    private String employeeId;
    private String department;
    private Date joiningDate;
    private Boolean isActive;
}
