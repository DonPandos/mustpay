package com.mustpay.encryptrestapi.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DecryptResponse {
    @JsonProperty("fio")
    private String decryptedUserInfo;
}
