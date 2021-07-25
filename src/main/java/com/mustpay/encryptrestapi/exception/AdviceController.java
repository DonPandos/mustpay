package com.mustpay.encryptrestapi.exception;

import com.mustpay.encryptrestapi.dto.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> customException(CustomException ce) {
        ErrorResponse response = new ErrorResponse(
                ce.getErrorCode(),
                ce.getErrorMessage()
        );

        return new ResponseEntity<>(
                response,
                null,
                ce.getErrorCode()
        );
    }
}
