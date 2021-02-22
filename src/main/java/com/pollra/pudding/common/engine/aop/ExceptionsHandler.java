package com.pollra.pudding.common.engine.aop;

import com.pollra.pudding.common.engine.constant.Constant;
import com.pollra.pudding.common.engine.exception.ExceptionCode;
import com.pollra.pudding.common.engine.exception.ExceptionForm;
import com.pollra.pudding.common.engine.helper.exception.ExceptionHelper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

@Slf4j
@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> handleSQLException(SQLException e) {
        if(StringUtils.isNotEmpty(e.getMessage()) && StringUtils.startsWith(e.getMessage(), Constant.Message.ERROR)) {
            ExceptionForm exceptionForm = ExceptionHelper.getException(e.getMessage());
            return new ResponseEntity<>(exceptionForm, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
        }
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    @ExceptionHandler(UnsupportedEncodingException.class)
    public ResponseEntity<?> handleUnsupportedEncodingException(UnsupportedEncodingException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(ExceptionHelper.getException(ExceptionCode.E00020003), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<?> handleExpiredJwtException(ExpiredJwtException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(ExceptionHelper.getException(ExceptionCode.E00020002), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<?> handleSignatureException(SignatureException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(ExceptionHelper.getException(ExceptionCode.E00020001), HttpStatus.BAD_REQUEST);
    }

}
