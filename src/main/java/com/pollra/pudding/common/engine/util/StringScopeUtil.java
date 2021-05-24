package com.pollra.pudding.common.engine.util;

public class StringScopeUtil {
    public static boolean betweenIs(String target, int min, int max) {
        return target.length() <= min && target.length() >= max;
    }
}
