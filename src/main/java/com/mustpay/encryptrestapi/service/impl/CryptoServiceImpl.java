package com.mustpay.encryptrestapi.service.impl;

import com.mustpay.encryptrestapi.constants.ErrorConstants;
import com.mustpay.encryptrestapi.dto.request.DecryptRequest;
import com.mustpay.encryptrestapi.dto.request.EncryptRequest;
import com.mustpay.encryptrestapi.dto.response.DecryptResponse;
import com.mustpay.encryptrestapi.dto.response.EncryptResponse;
import com.mustpay.encryptrestapi.exception.CustomException;
import com.mustpay.encryptrestapi.model.UserModel;
import com.mustpay.encryptrestapi.repository.UserRepository;
import com.mustpay.encryptrestapi.service.CryptoService;
import com.mustpay.encryptrestapi.util.CryptoUtil;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CryptoServiceImpl implements CryptoService {

    private final UserRepository userRepository;
    private final CryptoUtil cryptoUtil;

    public CryptoServiceImpl(UserRepository userRepository, CryptoUtil cryptoUtil) {
        this.userRepository = userRepository;
        this.cryptoUtil = cryptoUtil;
    }

    @Override
    public EncryptResponse encrypt(EncryptRequest request) {
        UserModel user = userRepository.findById(request.getId())
                .orElseThrow(
                        () -> new CustomException(
                                HttpStatus.BAD_REQUEST.value(),
                                ErrorConstants.NO_SUCH_USER_ERROR
                        )
                );

        EncryptResponse response = new EncryptResponse();
        response.setEncryptedUserInfo(
                cryptoUtil.encrypt(user.getFullName())
        );
        return response;
    }

    @Override
    public DecryptResponse decrypt(DecryptRequest request) {
        DecryptResponse response = new DecryptResponse();
        response.setDecryptedUserInfo(
                cryptoUtil.decrypt(request.getEncryptedUserInfo())
        );
        return response;
    }
}
