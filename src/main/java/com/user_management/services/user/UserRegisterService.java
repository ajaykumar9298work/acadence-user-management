package com.user_management.services.user;

import com.user_management.models.request.user.CreateUserRequest;

public interface UserRegisterService {
    
    CreateUserRequest createUser(CreateUserRequest createUserRequest);

    CreateUserRequest updateUser(CreateUserRequest createUserRequest);

    CreateUserRequest deleteUser(String userId);

    CreateUserRequest viewUser(String userId);
}
