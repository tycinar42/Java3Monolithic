package com.tyc.Java3Monolithic.mapper;

import com.tyc.Java3Monolithic.dto.response.MusteriFindByIdResponseDto;
import com.tyc.Java3Monolithic.repository.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Mapperin spring tarafinda kullanilan yonetimi icin componentModel olarak spring yazilmali
 * En nihayetinde 2 sinifi karsilastirarak deger atamasi yapiyor. Bu nedenle karsilikli siniflarda
 * olmayan alanlar sorun yaratacaktir. Eslesmeyen alanlari es geciyoruz.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMusteriMapper {
    /**
     * Mapstruct instance'ini kendisi yaratir
     */
    IMusteriMapper INSATANCE = Mappers.getMapper(IMusteriMapper.class);

    /**
     * Buradan itibaren ilgili nesnelerin degerleri bir birine atanir
     */

    MusteriFindByIdResponseDto toMusteriFetFindByIdResponseDto(final Musteri musteri);
    Musteri toMusteri(final MusteriFindByIdResponseDto dto);

}
