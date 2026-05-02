package com.user_management.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_role_entity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRoles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String roleId;
    private String assignedDate;
}