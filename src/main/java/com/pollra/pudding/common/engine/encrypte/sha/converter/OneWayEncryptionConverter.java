package com.pollra.pudding.common.engine.encrypte.sha.converter;

import com.pollra.pudding.common.engine.encrypte.sha.algorithm.OneWayEncryptionAlgorithm;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.PreUpdate;
import java.security.NoSuchAlgorithmException;

/**
 * @author pollra
 * @description PasswordEncryptionConverter
 * @since 2021.02.01
 **********************************************************************************************************************/
@Converter
public class OneWayEncryptionConverter implements AttributeConverter<String, String> {
    @PreUpdate
    public void encrypt(Object attribute) throws NoSuchAlgorithmException {
        OneWayEncryptionAlgorithm algorithm = OneWayEncryptionAlgorithm.getInstance();
        attribute= algorithm.hashing((String) attribute);
    }

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(String attribute) {
        OneWayEncryptionAlgorithm algorithm = OneWayEncryptionAlgorithm.getInstance();
        return algorithm.hashing((String) attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}
