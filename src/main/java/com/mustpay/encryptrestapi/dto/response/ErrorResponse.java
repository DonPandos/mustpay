package com.mustpay.encryptrestapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private Integer errorCode;
    private String errorMessage;
}
