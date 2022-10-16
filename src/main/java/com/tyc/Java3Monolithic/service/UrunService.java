package com.tyc.Java3Monolithic.service;


import com.tyc.Java3Monolithic.dto.request.UrunSaveRequestDto;
import com.tyc.Java3Monolithic.dto.response.UrunGetFindByIdResponseDto;
import com.tyc.Java3Monolithic.mapper.IUrunMapper;
import com.tyc.Java3Monolithic.repository.IUrunRepository;
import com.tyc.Java3Monolithic.repository.entity.Urun;
import com.tyc.Java3Monolithic.utility.ServiceManager;
import org.springframework.stereotype.Service;


@Service
public class UrunService extends ServiceManager<Urun, Long> {

    private final IUrunRepository urunRepository;

    public UrunService(IUrunRepository urunRepository) {
        super(urunRepository);
        this.urunRepository = urunRepository;
    }

    public UrunGetFindByIdResponseDto findByIdDto(Long id) {
        Urun urun = urunRepository.getReferenceById(id);
        return UrunGetFindByIdResponseDto.builder()
                .ad(urun.getAd())
                .marka(urun.getMarka())
                .model(urun.getModel())
                .build();
    }

    public Urun save(UrunSaveRequestDto dto) {
        Urun urun = IUrunMapper.INSTANCE.toUrun(dto);
        urun.setIsactive(true);
        urun.setCreatedate(System.currentTimeMillis());
        urunRepository.save(urun);
        return urun;
    }
}