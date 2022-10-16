package com.tyc.Java3Monolithic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UrunGetFindByIdResponseDto {
    String ad;
    String marka;
    String model;

}
