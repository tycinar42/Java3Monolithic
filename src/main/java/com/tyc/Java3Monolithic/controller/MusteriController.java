package com.tyc.Java3Monolithic.controller;

import com.tyc.Java3Monolithic.repository.entity.Musteri;
import com.tyc.Java3Monolithic.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/musteri")
@RequiredArgsConstructor
public class MusteriController {
    private final MusteriService musteriService;

    @GetMapping("/save")
    public String saveMusteri(String ad, String soyad, String adres) {
        Musteri musteri = Musteri.builder()
                .ad(ad)
                .soyad(soyad)
                .adres(adres)
                .build();
        musteriService.save(musteri);
        return "Musteri kaydedildi.";
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Musteri>> findAll() {
        return ResponseEntity.ok(musteriService.findAll());
    }

    @GetMapping("/findbyadres")
    public ResponseEntity<List<Musteri>> findByAdres(String adres) {
        return ResponseEntity.ok(musteriService.findByAdres(adres));
    }

}
