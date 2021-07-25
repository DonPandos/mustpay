package com.mustpay.encryptrestapi.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EncryptResponse {
    @JsonProperty("fio_encr")
    private String encryptedUserInfo;
}
