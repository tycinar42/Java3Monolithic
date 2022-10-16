package com.tyc.Java3Monolithic.mapper;

import com.tyc.Java3Monolithic.dto.request.UrunSaveRequestDto;
import com.tyc.Java3Monolithic.dto.response.UrunGetFindByIdResponseDto;
import com.tyc.Java3Monolithic.repository.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUrunMapper {

    IUrunMapper INSTANCE = Mappers.getMapper(IUrunMapper.class);

    UrunGetFindByIdResponseDto toUrunGetFindByIdResponseDto(final Urun urun);
    Urun toUrun(final UrunSaveRequestDto dto);
}
