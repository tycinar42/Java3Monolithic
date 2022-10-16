package com.tyc.Java3Monolithic.controller;

import com.tyc.Java3Monolithic.dto.request.UrunSaveRequestDto;
import com.tyc.Java3Monolithic.dto.response.UrunGetFindByIdResponseDto;
import com.tyc.Java3Monolithic.repository.entity.Urun;
import com.tyc.Java3Monolithic.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tyc.Java3Monolithic.constants.EndPoints.*;

@RestController
@RequestMapping(VERSION + API + URUN)
@RequiredArgsConstructor
public class UrunController {

    private final UrunService service;

    @GetMapping(SAVE)
    public String  save(String ad, String marka, String model,
                               Double fiyat, Integer stok) {
        Urun urun = Urun.builder()
                .ad(ad)
                .marka(marka)
                .model(model)
                .fiyat(fiyat)
                .stok(stok)
                .build();
        return ResponseEntity.ok(service.save(urun)) + " Urun kaydedildi.";
    }

    @GetMapping(URUN_SAVE_DTO)
    public String save(UrunSaveRequestDto dto) {
        service.save(dto);
        return "Urun kaydedildi.";
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<Urun>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(FINDBYID)
    public UrunGetFindByIdResponseDto getFindById(Long id) {
        return service.findByIdDto(id);
    }

}
