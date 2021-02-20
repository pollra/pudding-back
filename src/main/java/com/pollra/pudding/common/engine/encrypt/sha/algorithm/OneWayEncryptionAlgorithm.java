package com.pollra.pudding.common.engine.encrypt.sha.algorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author pollra
 * @description PasswordEncryptionAlgorithm
 * @since 2021.02.01
 **********************************************************************************************************************/
public class OneWayEncryptionAlgorithm {
    private static final String SALT = "sigenan";

    public static final OneWayEncryptionAlgorithm INSTANCE = new OneWayEncryptionAlgorithm();
    private OneWayEncryptionAlgorithm() { if(INSTANCE != null) throw new AssertionError(); }
    public static OneWayEncryptionAlgorithm getInstance() { return INSTANCE; }

    public String hashing(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        for (int i = 0; i < 7_021; i++) {
            String temp = password+SALT;
            digest.update(temp.getBytes());
            password = byteToString(digest.digest());
        }
        return password;
    }

    private String byteToString(byte[] data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : data) stringBuilder.append(String.format("%02x",b));
        return stringBuilder.toString();
    }
}
