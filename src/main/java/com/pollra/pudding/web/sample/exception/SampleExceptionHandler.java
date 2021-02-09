package com.pollra.pudding.web.sample.exception;

import com.pollra.pudding.common.engine.helper.exception.ExceptionHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class SampleExceptionHandler {
    @ExceptionHandler(SampleException.class)
    public ResponseEntity<?> handleRuntimeException(SampleException e) {
        return new ResponseEntity<>(ExceptionHelper.getException(e.code), e.status);
    }
}
