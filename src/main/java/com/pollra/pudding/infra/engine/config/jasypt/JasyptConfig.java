package com.pollra.pudding.infra.engine.config.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pollra
 * @description 소스코드 암호화
 * @since 2021.02.09
 **********************************************************************************************************************/
@Configuration
public class JasyptConfig {

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword              (System.getenv("POLLRA_CODE_ENCRYPT_PASSWORD"));
        config.setPoolSize              (System.getenv("POLLRA_CODE_ENCRYPT_POOL_SIZE"));
        config.setAlgorithm             (System.getenv("POLLRA_CODE_ENCRYPT_ALGORITHM"));
        config.setKeyObtentionIterations(System.getenv("POLLRA_CODE_ENCRYPT_STRETCHING"));
        config.setIvGeneratorClassName  (System.getenv("POLLRA_CODE_ENCRYPT_IV_GENERATOR"));
        encryptor.setConfig(config);
        return encryptor;
    }
}