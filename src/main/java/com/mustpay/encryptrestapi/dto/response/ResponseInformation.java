package com.mustpay.encryptrestapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseInformation {
    private Integer code;
    private String message;
}
