package com.pollra.pudding.infra.engine.encrypt.sha.algorithm;

import com.pollra.pudding.infra.engine.helper.property.PropertyHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author pollra
 * @description PasswordEncryptionAlgorithm
 * @since 2021.02.01
 **********************************************************************************************************************/
public class OneWayEncryptionAlgorithm {
    public static final OneWayEncryptionAlgorithm INSTANCE = new OneWayEncryptionAlgorithm();
    private OneWayEncryptionAlgorithm() { if(INSTANCE != null) throw new AssertionError(); }
    public static OneWayEncryptionAlgorithm getInstance() { return INSTANCE; }

    public String hashing(String password) throws NoSuchAlgorithmException {
        final String algorithm = PropertyHelper.getSpring().getEncrypt().getAlgorithm();
        final String salt = PropertyHelper.getSpring().getEncrypt().getSalt();
        final int hashing = Integer.parseInt(PropertyHelper.getSpring().getEncrypt().getHashing());

        MessageDigest digest = MessageDigest.getInstance(algorithm);
        for (int i = 0; i < hashing; i++) {
            String temp = password+salt;
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
