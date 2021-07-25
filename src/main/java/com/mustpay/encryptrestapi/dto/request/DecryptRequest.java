package com.mustpay.encryptrestapi.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DecryptRequest {
    @JsonProperty("fio_encr")
    private String encryptedUserInfo;
}
