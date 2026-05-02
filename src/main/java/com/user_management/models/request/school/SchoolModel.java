package com.user_management.models.request.school;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchoolModel {

    private String schoolCode;
    private String name;
    private String address;
    private String email;
    private String primaryPhone;
    private String secondaryPhone;
}
