package com.pollra.pudding.common.engine.helper.message;

import com.pollra.pudding.common.engine.exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {

    private static MessageSource messageSource = null;

    @Autowired
    private MessageHelper(MessageSource messageSource) {
        MessageHelper.messageSource = messageSource;
    }

    public static String getMessage(ExceptionCode exceptionCode) {
        return messageSource.getMessage(exceptionCode.name(), null, null);
    }

    public static String getMessage(ExceptionCode exceptionCode, String... params) {
        return messageSource.getMessage(exceptionCode.name(), params, null);
    }

    public static String getMessage(MessageCode messageCode) {
        return messageSource.getMessage(messageCode.name(), null, null);
    }

    public static String getMessage(MessageCode messageCode, String... params) {
        return messageSource.getMessage(messageCode.name(), params, null);
    }
}
