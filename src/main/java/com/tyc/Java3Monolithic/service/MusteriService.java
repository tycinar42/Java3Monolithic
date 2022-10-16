package com.tyc.Java3Monolithic.service;

import com.tyc.Java3Monolithic.repository.IMusteriRepository;
import com.tyc.Java3Monolithic.repository.entity.Musteri;
import com.tyc.Java3Monolithic.repository.entity.view.VwMusteri;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * !!!DIKKAT!!!
 * Servisi isaretlemeyi unutma
 */
@Service
@RequiredArgsConstructor
public class MusteriService {

    /**
     * interface olarak ekledigimiz service ya da repository gibi siniflardan
     * instance almak icin Spring @Autowired annotation'ini kullanabiliriz
     */
//    @Autowired
//    IMusteriRepository musteriRepository;

    private final IMusteriRepository musteriRepository;

    public Boolean isExistUser(String username, String password) {
        return musteriRepository.isExistMusteri(username, password);
    }

    /**
     * Dikkat, musteriyi kaydetmek icin verdiginizde id'si yoktur.
     * @param musteri
     * @return
     */

    public Musteri save(Musteri musteri) {
        return musteriRepository.save(musteri);
    }

    /**
     * id de entity icinde verilmeli
     * @param musteri
     * @return
     */

    public Musteri update(Musteri musteri) {
        return musteriRepository.save(musteri);
    }

    public void delete(Musteri musteri) {
        musteriRepository.delete(musteri);
    }

    public List<Musteri> findAll() {
        return musteriRepository.findAll();
    }

    public List<Musteri> findByAdres(String adres) {
        return musteriRepository.findByAdres(adres);
    }

    public Iterable<Musteri> saveAll(List<Musteri> musteriler){
        musteriler.forEach(musteri -> {
            musteri.setCreatedate(System.currentTimeMillis());
        });
        return musteriRepository.saveAll(musteriler);
    }

    public List<VwMusteri> getMusteriView(){
        return musteriRepository.findAllView();
    }
}
