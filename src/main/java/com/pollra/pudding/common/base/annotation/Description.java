package com.pollra.pudding.common.base.annotation;

import com.pollra.pudding.common.engine.constant.Constant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {

    String value() default Constant.String.EMPTY;
}