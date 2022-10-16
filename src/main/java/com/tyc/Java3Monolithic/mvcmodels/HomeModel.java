package com.tyc.Java3Monolithic.mvcmodels;

import com.tyc.Java3Monolithic.repository.entity.Urun;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HomeModel {
    String baslik;
    List<String> menulistesi;
    String kullaniciadi;
    String avatar;
    List<Urun> urunler;
}
