package com.user_management.models.request.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    
    private String firstName;
    private String lastName;
    private String email;
    private String primaryPhone;
    private String secondaryPhone;
    private String setPassword;

}
