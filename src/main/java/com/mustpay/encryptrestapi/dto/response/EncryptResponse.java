package com.mustpay.encryptrestapi.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EncryptResponse extends BaseResponse{
    @JsonProperty("fio_encr")
    private String encryptedUserInfo;
}
