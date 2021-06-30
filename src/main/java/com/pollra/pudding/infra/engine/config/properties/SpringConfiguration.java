package com.pollra.pudding.infra.engine.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pollra
 * @description SpringConfiguration
 * @since 2021.03.15
 **********************************************************************************************************************/
@Data
@Component
@ConfigurationProperties(prefix="spring")
public class SpringConfiguration {

    private Encrypt encrypt;

    @Data
    public static class Encrypt {
        private String salt;
        private String hashing;
        private String algorithm;
    }
}
