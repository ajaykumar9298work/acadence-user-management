package com.user_management.utils;

import com.user_management.constants.UtilConstant;
import com.user_management.models.response.ApplicationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Component
public class CommonUtils {

    public String getDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(dateTimeFormatter);
    }

    public ApplicationResponse createSuccessResponse() {
        return ApplicationResponse.builder()
                .status(UtilConstant.SUCCESS)
                .message("Successfully saved the data")
                .httpStatusCode(HttpStatus.CREATED)
                .build();
    }

    public ApplicationResponse getSuccessResponse() {
        return ApplicationResponse.builder()
                .status(UtilConstant.SUCCESS)
                .message("Successfully fetched the data")
                .httpStatusCode(HttpStatus.OK)
                .build();
    }


    public ApplicationResponse createFailureResponse() {
        return ApplicationResponse.builder()
                .status(UtilConstant.FAILED)
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message("Failed to saved the data")
                .build();
    }

    public ApplicationResponse notFoundFailureResponse() {
        return ApplicationResponse.builder()
                .status(UtilConstant.FAILED)
                .httpStatusCode(HttpStatus.NOT_FOUND)
                .message("Failed to fetch the data")
                .build();
    }

}
