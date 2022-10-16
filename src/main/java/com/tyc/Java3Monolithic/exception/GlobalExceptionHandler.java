package com.tyc.Java3Monolithic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.badRequest().body("Beklenmeyen bir hata oldu... " + ex.getMessage());
    }

    @ExceptionHandler(MonolitichManagerException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleMonolitichExeption(MonolitichManagerException ex) {
        ErrorType errorType = ex.getErrorType();
        HttpStatus httpStatus = errorType.getHttpStatus();
        return new ResponseEntity(createError(errorType, ex), httpStatus);
    }

    /**
     * Error mesajlarimizi ozel bir method icinde create etmeliyiz.
     * Cunku olusan hatalarin loglanmasi ya da farkli islemlere tabi
     * tutulmasi icin ayrica bir method kullanmak daha dogru olacaktir.
     */

    private ErrorMessage createError(ErrorType errorType, Exception exception) {
        System.out.println("Hata olustu: " + exception.getMessage());
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }
}
