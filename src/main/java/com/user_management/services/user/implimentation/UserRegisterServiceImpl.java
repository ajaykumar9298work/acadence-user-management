package com.user_management.services.user.implimentation;

import com.user_management.models.entity.UserEntity;
import com.user_management.models.request.user.CreateUserRequest;
import com.user_management.repository.UserRepository;
import com.user_management.services.user.UserRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    private final UserRepository userRepository;

    @Override
    public CreateUserRequest createUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = UserEntity.builder()
                .userId("")
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .primaryPhone(createUserRequest.getPrimaryPhone())
                .secondaryPhone(createUserRequest.getSecondaryPhone())
                .hashedPassword(createUserRequest.getSetPassword())
                .isActive(true)
                .build();
        userRepository.save(userEntity);
        return createUserRequest;
    }

    @Override
    public CreateUserRequest updateUser(CreateUserRequest createUserRequest) {
        return null;
    }

    @Override
    public CreateUserRequest deleteUser(String userId) {
        return null;
    }

    @Override
    public CreateUserRequest viewUser(String userId) {
        return null;
    }
}
