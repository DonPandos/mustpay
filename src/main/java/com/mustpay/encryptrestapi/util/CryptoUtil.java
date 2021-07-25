package com.mustpay.encryptrestapi.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class CryptoUtil {

    @Value("${crypto.salt}")
    private String salt;

    @Value("${crypto.password}")
    private String password;

    public String encrypt(String str) {
        TextEncryptor textEncryptor = Encryptors.queryableText(password, salt);
        return textEncryptor.encrypt(
                Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8))
        );
    }

    public String decrypt(String str) {
        TextEncryptor textEncryptor = Encryptors.queryableText(password, salt);
        return new String(
                Base64.getDecoder().decode(textEncryptor.decrypt(str)),
                StandardCharsets.UTF_8
        );
    }
}
