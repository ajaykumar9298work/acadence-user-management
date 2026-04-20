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
public class UserEntity {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String primaryPhone;
    private String secondaryPhone;
    private String hashedPassword;
    private boolean isActive;
    private Date createdDate;
    private Date updatedDate;
}
