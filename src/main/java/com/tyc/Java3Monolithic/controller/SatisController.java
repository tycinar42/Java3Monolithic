package com.tyc.Java3Monolithic.controller;

import static com.tyc.Java3Monolithic.constants.EndPoints.*;

import com.tyc.Java3Monolithic.exception.ErrorType;
import com.tyc.Java3Monolithic.exception.MonolitichManagerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestAPI yazmak icin kullanilir
 */
@RestController
@RequestMapping(SATIS)
public class SatisController {
    @GetMapping(SAVE)
    public String save(){
        return "Kayit Basarili";
    }
    @GetMapping(FINDALL)
    public String findAll() {
        return "Kayitlar Basarili Bir Sekilde Getirildi";
    }
    @GetMapping("/hataolustur")
    public String  hataOlustur(){
        throw  new MonolitichManagerException(ErrorType.MUSTERI_BULUNAMADI);
    }
}
