package com.tyc.Java3Monolithic.mapper;

import com.tyc.Java3Monolithic.dto.request.UrunSaveRequestDto;
import com.tyc.Java3Monolithic.dto.response.UrunGetFindByIdResponseDto;
import com.tyc.Java3Monolithic.repository.entity.Urun;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-29T12:03:10+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class IUrunMapperImpl implements IUrunMapper {

    @Override
    public UrunGetFindByIdResponseDto toUrunGetFindByIdResponseDto(Urun urun) {
        if ( urun == null ) {
            return null;
        }

        UrunGetFindByIdResponseDto.UrunGetFindByIdResponseDtoBuilder urunGetFindByIdResponseDto = UrunGetFindByIdResponseDto.builder();

        urunGetFindByIdResponseDto.ad( urun.getAd() );
        urunGetFindByIdResponseDto.marka( urun.getMarka() );
        urunGetFindByIdResponseDto.model( urun.getModel() );

        return urunGetFindByIdResponseDto.build();
    }

    @Override
    public Urun toUrun(UrunSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Urun.UrunBuilder<?, ?> urun = Urun.builder();

        urun.ad( dto.getAd() );
        urun.marka( dto.getMarka() );
        urun.model( dto.getModel() );
        urun.fiyat( dto.getFiyat() );
        urun.stok( dto.getStok() );

        return urun.build();
    }
}
