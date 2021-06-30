package com.pollra.pudding.infra.engine.helper.exception;

import com.pollra.pudding.infra.engine.exception.ExceptionCode;
import com.pollra.pudding.infra.engine.exception.ExceptionForm;
import com.pollra.pudding.infra.engine.helper.message.MessageHelper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionHelper {
    public static ExceptionForm getException(ExceptionCode exceptionCode) {
        String        exceptionMessage = MessageHelper.getMessage(exceptionCode);
        ExceptionForm exceptionForm    = ExceptionForm.builder()
                .code   (exceptionCode)
                .message(exceptionMessage)
                .build();

        printLog(exceptionForm);
        return exceptionForm;
    }

    public static ExceptionForm getException(String code) {
        ExceptionCode exceptionCode    = ExceptionCode.valueOf(code);
        String        exceptionMessage = MessageHelper.getMessage(exceptionCode);
        ExceptionForm exceptionForm    = ExceptionForm.builder()
                .code   (exceptionCode)
                .message(exceptionMessage)
                .build();

        printLog(exceptionForm);
        return exceptionForm;
    }

    private static void printLog(ExceptionForm exceptionForm) {
        log.error(exceptionForm.toString());
    }
}