package com.tyc.Java3Monolithic.mapper;

import com.tyc.Java3Monolithic.dto.response.MusteriFindByIdResponseDto;
import com.tyc.Java3Monolithic.repository.entity.Musteri;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-29T12:03:10+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class IMusteriMapperImpl implements IMusteriMapper {

    @Override
    public MusteriFindByIdResponseDto toMusteriFetFindByIdResponseDto(Musteri musteri) {
        if ( musteri == null ) {
            return null;
        }

        MusteriFindByIdResponseDto.MusteriFindByIdResponseDtoBuilder musteriFindByIdResponseDto = MusteriFindByIdResponseDto.builder();

        musteriFindByIdResponseDto.ad( musteri.getAd() );
        musteriFindByIdResponseDto.soyad( musteri.getSoyad() );
        musteriFindByIdResponseDto.adres( musteri.getAdres() );
        musteriFindByIdResponseDto.telefon( musteri.getTelefon() );
        musteriFindByIdResponseDto.dogumtarihi( musteri.getDogumtarihi() );
        musteriFindByIdResponseDto.email( musteri.getEmail() );
        musteriFindByIdResponseDto.username( musteri.getUsername() );

        return musteriFindByIdResponseDto.build();
    }

    @Override
    public Musteri toMusteri(MusteriFindByIdResponseDto dto) {
        if ( dto == null ) {
            return null;
        }

        Musteri.MusteriBuilder<?, ?> musteri = Musteri.builder();

        musteri.ad( dto.getAd() );
        musteri.soyad( dto.getSoyad() );
        musteri.adres( dto.getAdres() );
        musteri.telefon( dto.getTelefon() );
        musteri.dogumtarihi( dto.getDogumtarihi() );
        musteri.email( dto.getEmail() );
        musteri.username( dto.getUsername() );

        return musteri.build();
    }
}
