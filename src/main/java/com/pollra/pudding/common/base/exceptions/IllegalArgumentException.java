package com.pollra.pudding.common.base.exceptions;

import com.pollra.pudding.common.engine.exception.ExceptionCode;
import org.springframework.http.HttpStatus;

/**
 * @since       2021.04.15
 * @author      pollra
 * @description IllegalArgumentException
 **********************************************************************************************************************/
public class IllegalArgumentException extends RuntimeException{
	public static ExceptionCode code   = ExceptionCode.E00010003;
	public static HttpStatus	status = HttpStatus.INTERNAL_SERVER_ERROR;
	
	public IllegalArgumentException(){
		super(code.name());
	}
	
	public IllegalArgumentException(ExceptionCode exceptionCode, HttpStatus httpStatus) {
		super(exceptionCode.name());
		code   = exceptionCode;
		status = httpStatus;
	}
}
