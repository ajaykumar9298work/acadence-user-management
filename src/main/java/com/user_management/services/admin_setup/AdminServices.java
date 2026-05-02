package com.user_management.services.admin_setup;

import com.user_management.models.request.school.SchoolModel;
import com.user_management.models.response.ApplicationResponse;

public interface AdminServices {

    ApplicationResponse onboardSchool(SchoolModel createSchoolRequest);

    ApplicationResponse modifySchool(SchoolModel createSchoolRequest, String schoolCode);

    ApplicationResponse viewSchool(String schoolCode);

    ApplicationResponse listSchools();
}
