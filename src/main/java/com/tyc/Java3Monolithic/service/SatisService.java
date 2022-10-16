package com.tyc.Java3Monolithic.service;

import com.tyc.Java3Monolithic.repository.ISatisRepository;
import com.tyc.Java3Monolithic.repository.entity.Satis;
import com.tyc.Java3Monolithic.utility.ServiceManager;
import org.springframework.stereotype.Service;


@Service
public class SatisService extends ServiceManager<Satis, Long> {
    /**
     * 1- Burada satis islemleri ile ilgili veritabani kullanacagi icin SatisRepository bu sinifta olmali
     */

    private final ISatisRepository satisRepository;

    public SatisService(ISatisRepository satisRepository) {
        super(satisRepository);
        this.satisRepository = satisRepository;
    }






}
