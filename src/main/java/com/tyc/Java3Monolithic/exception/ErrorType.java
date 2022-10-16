package com.tyc.Java3Monolithic.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    MUSTERI_BULUNAMADI(1003, "Aradiginiz musteri kayitlarda bulunamadi", INTERNAL_SERVER_ERROR),
    MUSTERI_SILINEMEDI(1004, "Musteri silinemedi", INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
