package com.user_management.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "school_entity")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String schoolCode;
    private String name;
    private String address;
    private String email;
    private String primaryPhone;
    private String secondaryPhone;
    private String createdAt;
    private String updatedAt;

}
