package com.pollra.pudding.infra.base.annotation;

import com.pollra.pudding.infra.engine.constant.Constant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {

    String value() default Constant.String.EMPTY;
}
