package com.mustpay.encryptrestapi.service;

import com.mustpay.encryptrestapi.dto.request.DecryptRequest;
import com.mustpay.encryptrestapi.dto.request.EncryptRequest;
import com.mustpay.encryptrestapi.dto.response.DecryptResponse;
import com.mustpay.encryptrestapi.dto.response.EncryptResponse;

public interface CryptoService {
    public EncryptResponse encrypt(EncryptRequest request);
    public DecryptResponse decrypt(DecryptRequest request);
}
