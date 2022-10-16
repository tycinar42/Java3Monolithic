package com.tyc.Java3Monolithic.mvcmodels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UrunModel {
    private String urunAdi;
    private String username;
    private String title;
}
