package com.pollra.pudding.common.engine.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pollra
 * @description PropertyConfiguration
 * @since 2021.02.22
 **********************************************************************************************************************/
@Data
@Component
@ConfigurationProperties(prefix="property")
public class PropertyConfiguration {
    private String name;
    private Api api;
    private Jwt jwt;

    @Data
    public static class Api {
        private String endPoint;
    }

    @Data
    public static class Jwt {
        private String key;
    }
}
