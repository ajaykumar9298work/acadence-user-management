package com.user_management.models.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponseModel {
    private String errorCode;
    private String errorMessage;

}
