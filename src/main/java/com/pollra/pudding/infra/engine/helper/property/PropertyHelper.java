package com.pollra.pudding.infra.engine.helper.property;

import com.pollra.pudding.infra.engine.config.properties.PropertyConfiguration;
import com.pollra.pudding.infra.engine.config.properties.SpringConfiguration;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author pollra
 * @description PropertyHelper
 * @since 2021.02.21
 **********************************************************************************************************************/
@Component
public class PropertyHelper {

    @Getter
    private static PropertyConfiguration property;

    @Getter
    private static SpringConfiguration spring;

    @Autowired
    public PropertyHelper(PropertyConfiguration propertyConfiguration, SpringConfiguration springConfiguration) {
        PropertyHelper.property = propertyConfiguration;
        PropertyHelper.spring   = springConfiguration;
    }
}
