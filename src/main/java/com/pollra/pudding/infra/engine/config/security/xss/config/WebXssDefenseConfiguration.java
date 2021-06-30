package com.pollra.pudding.infra.engine.config.security.xss.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pollra.pudding.infra.engine.config.security.xss.converter.HTMLCharacterEscapes;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author pollra
 * @description WebXssDefenseConfiguration
 * @since 2021.02.10
 **********************************************************************************************************************/
@Configuration
@RequiredArgsConstructor
public class WebXssDefenseConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(htmlEscapingConverter());
    }

    private HttpMessageConverter<?> htmlEscapingConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
        MappingJackson2HttpMessageConverter httpMessageConverter = new MappingJackson2HttpMessageConverter();
        httpMessageConverter.setObjectMapper(objectMapper);
        return httpMessageConverter;
    }
}
