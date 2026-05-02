package com.user_management.services.admin_setup.implimentation;


import com.user_management.models.entity.SchoolEntity;
import com.user_management.models.request.school.SchoolModel;
import com.user_management.models.response.ApplicationResponse;
import com.user_management.models.response.ErrorResponseModel;
import com.user_management.repository.SchoolRepository;
import com.user_management.services.admin_setup.AdminServices;
import com.user_management.utils.CommonUtils;
import com.user_management.utils.mappers.SchoolMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AdminServicesImpl implements AdminServices {

    private final CommonUtils utils;
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Override
    public ApplicationResponse onboardSchool(SchoolModel request) {
        ApplicationResponse response = null;

        if (schoolRepository.existsBySchoolCode(request.getSchoolCode())) {
            ErrorResponseModel errorResponseModel = ErrorResponseModel.builder().errorMessage("School Code already exists")
                    .errorCode("409-A")
                    .build();
            response = utils.createFailureResponse();
            response.setError(errorResponseModel);
            response.setHttpStatusCode(HttpStatus.CONFLICT);
            return response;
        }

        SchoolEntity schoolEntity = schoolMapper.toEntity(request);
        schoolEntity.setCreatedAt(utils.getDateTime());
        schoolRepository.save(schoolEntity);

        response = utils.createSuccessResponse();
        response.setData(request);
        return response;
    }

    @Override
    public ApplicationResponse modifySchool(SchoolModel request, String schoolCode) {
        ApplicationResponse response;

        if (!schoolRepository.existsBySchoolCode(schoolCode)) {
            ErrorResponseModel errorResponseModel = ErrorResponseModel.builder().errorMessage("School doesn't exists")
                    .errorCode("404-A")
                    .build();
            response = utils.notFoundFailureResponse();
            response.setError(errorResponseModel);
            return response;
        }


        schoolRepository.updateSchoolDetailsByCode(schoolCode, request.getName(), request.getAddress(), request.getEmail(),
                request.getPrimaryPhone(), request.getSecondaryPhone(), utils.getDateTime());

        response = utils.createSuccessResponse();
        response.setData(request);
        return response;
    }

    @Override
    public ApplicationResponse viewSchool(String schoolCode) {
        ApplicationResponse response;

        SchoolEntity schoolEntity = schoolRepository.findBySchoolCode(schoolCode);
        if (Objects.isNull(schoolEntity)) {
            ErrorResponseModel errorResponseModel = ErrorResponseModel.builder().errorMessage("School doesn't exists")
                    .errorCode("404-A")
                    .build();
            response = utils.notFoundFailureResponse();
            response.setError(errorResponseModel);
            return response;
        }
        response = utils.getSuccessResponse();
        response.setData(schoolMapper.toModel(schoolEntity));

        return response;
    }

    @Override
    public ApplicationResponse listSchools() {
        ApplicationResponse response;

        List<SchoolEntity> schoolEntities = schoolRepository.findAll();
        List<SchoolModel> schoolModels = new ArrayList<>();
        for (SchoolEntity schoolEntity : schoolEntities) {
            schoolModels.add(schoolMapper.toModel(schoolEntity));
        }

        response = utils.getSuccessResponse();
        response.setData(schoolModels);
        return response;
    }
}
