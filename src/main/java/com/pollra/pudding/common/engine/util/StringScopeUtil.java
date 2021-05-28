package com.pollra.pudding.common.engine.util;

public class StringScopeUtil {

    /**
     * min 보다 크거나 같고, max 보다 작거나 같을 경우 true
     */
    public static boolean betweenIs(String target, int min, int max) {
        target = target.trim();
        return min <= target.length() && max >= target.length();
    }


    public static boolean notBetweenIs(String target, int min, int max) {
        return ! betweenIs(target, min, max);
    }
}
