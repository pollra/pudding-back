package com.pollra.pudding.infra.engine.security;

/**
 * @author pollra
 * @description AbstractAuthenticationHandler
 * @since 2021.03.15
 **********************************************************************************************************************/
public interface AbstractAuthenticationHandler {
    default boolean preHandle() {

        return false;
    }
}
