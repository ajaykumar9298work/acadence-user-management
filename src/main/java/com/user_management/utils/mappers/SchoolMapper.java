package com.user_management.utils.mappers;

import com.user_management.models.entity.SchoolEntity;
import com.user_management.models.request.school.SchoolModel;
import com.user_management.utils.CommonUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SchoolMapper {

    private final CommonUtils utils;

    public SchoolEntity toEntity(SchoolModel request) {
        return SchoolEntity.builder()
                .schoolCode(request.getSchoolCode())
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .primaryPhone(request.getPrimaryPhone())
                .secondaryPhone(request.getSecondaryPhone())
                .build();
    }

    public SchoolModel toModel(SchoolEntity entity) {
        return SchoolModel.builder()
                .schoolCode(entity.getSchoolCode())
                .name(entity.getName())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .primaryPhone(entity.getPrimaryPhone())
                .secondaryPhone(entity.getSecondaryPhone())
                .build();
    }
}