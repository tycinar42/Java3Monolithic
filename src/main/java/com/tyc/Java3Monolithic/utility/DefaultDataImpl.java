package com.tyc.Java3Monolithic.utility;


import com.tyc.Java3Monolithic.repository.IMusteriRepository;
import com.tyc.Java3Monolithic.repository.IUrunRepository;
import com.tyc.Java3Monolithic.repository.entity.Musteri;
import com.tyc.Java3Monolithic.repository.entity.Urun;
import com.tyc.Java3Monolithic.service.MusteriService;
import com.tyc.Java3Monolithic.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Uyglama ayağa kalarken veritabanına default verileri eklemek için kullanılır.
 * ancak bu sınıfın otomatik çalışması gerekecek.
 */
@RequiredArgsConstructor
@Component
public class DefaultDataImpl {

    private final MusteriService musteriService;
    private final UrunService urunService;

    @PostConstruct
    private void create() {
        saveMusteri();
        saveUrun();
    }

    private void saveMusteri() {
        Musteri musteri;
        musteri = Musteri.builder()
                .ad("İpek")
                .soyad("ÇINAR")
                .adres("Almanya")
                .telefon("555 555 55 55")
                .dogumtarihi(2019)
                .email("ipekhelen@tycinar.com")
                .build();

        Musteri musteri2;
        musteri2 = Musteri.builder()
                .ad("Muhammet")
                .soyad("HOCA")
                .adres("Ankara")
                .telefon("532 236 12 34")
                .dogumtarihi(1990)
                .email("muhammethoca@gmail.com")
                .build();

        Musteri musteri3;
        musteri3 = Musteri.builder()
                .ad("Taha Yasin")
                .soyad("ÇINAR")
                .adres("Antalya")
                .telefon("542 780 75 75")
                .dogumtarihi(1993)
                .email("info@tycinar.com")
                .build();

        Musteri musteri4;
        musteri4 = Musteri.builder()
                .ad("Sena Aybüke")
                .soyad("ASLAN")
                .adres("Malatya")
                .telefon("541 972 10 20")
                .dogumtarihi(1993)
                .email("aybuke@gmail.com")
                .build();

        Musteri musteri5;
        musteri5 = Musteri.builder()
                .ad("Çağdaş")
                .soyad("OKTAY")
                .adres("İzmir")
                .telefon("555 789 65 41")
                .dogumtarihi(1991)
                .email("cagdas@gmail.com")
                .build();

        Musteri musteri6;
        musteri6 = Musteri.builder()
                .ad("Mithat")
                .soyad("ORHAN")
                .adres("İstanbul")
                .telefon("555 545 85 63")
                .dogumtarihi(1993)
                .email("mithat@gmail.com")
                .build();

        musteriService.saveAll(List.of(musteri, musteri2, musteri3, musteri4, musteri5, musteri6));
    }

    private void saveUrun(){
        Urun urun = Urun.builder()
                .ad("Krem")
                .fiyat(120d)
                .isactive(true)
                .marka("CibiCibiCis")
                .model("Yara Kremi")
                .stok(500)
                .build();
        Urun urun2 = Urun.builder()
                .ad("Un")
                .fiyat(420d)
                .isactive(true)
                .marka("A Marka")
                .model("C Model")
                .stok(100)
                .build();
        Urun urun3 = Urun.builder()
                .ad("Süt")
                .fiyat(40d)
                .isactive(true)
                .marka("F Marka")
                .model("H Model")
                .stok(50)
                .build();
        Urun urun4 = Urun.builder()
                .ad("Makarna")
                .fiyat(20d)
                .isactive(true)
                .marka("C Marka")
                .model("S Model")
                .stok(125)
                .build();
        urunService.saveAll(Arrays.asList(urun, urun2,urun3,urun4));
    }




}
