package com.pollra.pudding.web.sample.exception;

import com.pollra.pudding.common.engine.exception.ExceptionCode;
import org.springframework.http.HttpStatus;

public class SampleException extends RuntimeException {

    public static ExceptionCode code   = ExceptionCode.E00010001;
    public static HttpStatus    status = HttpStatus.OK;

    public SampleException(ExceptionCode exceptionCode, HttpStatus httpStatus) {
        super(exceptionCode.name());
        code   = exceptionCode;
        status = httpStatus;
    }

    public SampleException(ExceptionCode exceptionCode, Exception exception) {
        super(exceptionCode.name(), exception);
        code = exceptionCode;
    }

}
