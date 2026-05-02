package com.user_management.controller;

import com.user_management.models.request.school.SchoolModel;
import com.user_management.models.response.ApplicationResponse;
import com.user_management.services.admin_setup.AdminServices;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/admin")
public class SchoolController {

    private final AdminServices adminServices;

    @PostMapping("/school")
    public ResponseEntity<ApplicationResponse> onboardSchool(@RequestBody @Valid SchoolModel createSchoolRequest) {
        ApplicationResponse response = adminServices.onboardSchool(createSchoolRequest);
        return new ResponseEntity<>(response, response.getHttpStatusCode());
    }

    @GetMapping("/schools")
    public ResponseEntity<ApplicationResponse> getAllSchools() {
        ApplicationResponse response = adminServices.listSchools();
        return new ResponseEntity<>(response, response.getHttpStatusCode());
    }

    @GetMapping("/school")
    public ResponseEntity<ApplicationResponse> getSchoolByCode(String schoolCode) {
        ApplicationResponse response = adminServices.viewSchool(schoolCode);
        return new ResponseEntity<>(response, response.getHttpStatusCode());
    }

    @PutMapping("/school")
    public ResponseEntity<ApplicationResponse> modifySchool(@RequestBody @Valid SchoolModel createSchoolRequest, String schoolCode) {
        ApplicationResponse response = adminServices.modifySchool(createSchoolRequest, schoolCode);
        return new ResponseEntity<>(response, response.getHttpStatusCode());
    }


}
