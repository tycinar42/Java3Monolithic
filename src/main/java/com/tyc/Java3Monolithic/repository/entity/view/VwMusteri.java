package com.tyc.Java3Monolithic.repository.entity.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VwMusteri {
    Long id;
    String ad;
    String soyad;
}
