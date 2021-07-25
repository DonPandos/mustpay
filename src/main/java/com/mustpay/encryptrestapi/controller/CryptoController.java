package com.mustpay.encryptrestapi.controller;

import com.mustpay.encryptrestapi.constants.Constants;
import com.mustpay.encryptrestapi.dto.request.DecryptRequest;
import com.mustpay.encryptrestapi.dto.request.EncryptRequest;
import com.mustpay.encryptrestapi.dto.response.DecryptResponse;
import com.mustpay.encryptrestapi.dto.response.EncryptResponse;
import com.mustpay.encryptrestapi.service.CryptoService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(Constants.APP_URL + "/crypto")
public class CryptoController {

    private final CryptoService cryptoService;
    private final Logger logger;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
        this.logger = Logger.getRootLogger();
    }

    @PostMapping("/encrypt")
    public ResponseEntity<EncryptResponse> encrypt(@RequestBody EncryptRequest request) {
        logger.info("Encrypt request: " + request.toString());
        EncryptResponse response = cryptoService.encrypt(request);
        logger.info("Encrypt response: " + response.toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/decrypt")
    public ResponseEntity<DecryptResponse> decrypt(@RequestBody DecryptRequest request) {
        logger.info("Decrypt request: " + request.toString());
        DecryptResponse response = cryptoService.decrypt(request);
        logger.info("Decrypt response: " + response.toString());
        return ResponseEntity.ok(response);
    }

}
