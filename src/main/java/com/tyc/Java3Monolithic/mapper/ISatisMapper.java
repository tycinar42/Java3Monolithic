package com.tyc.Java3Monolithic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISatisMapper {

    ISatisMapper INSTANCE = Mappers.getMapper(ISatisMapper.class);


}
