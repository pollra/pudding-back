package com.pollra.pudding.common.engine.helper.property;

import com.pollra.pudding.common.engine.config.properties.PropertyConfiguration;
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

    @Autowired
    public PropertyHelper(PropertyConfiguration propertyConfiguration) {
        PropertyHelper.property = propertyConfiguration;
    }
}
