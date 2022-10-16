package com.tyc.Java3Monolithic.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UrunSaveRequestDto {
    String ad;
    String marka;
    String model;
    Double fiyat;
    Integer stok;
}
