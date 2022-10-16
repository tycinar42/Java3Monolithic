package com.tyc.Java3Monolithic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MusteriFindByIdResponseDto {
    String ad;
    String soyad;
    String adres;
    String telefon;
    int dogumtarihi;
    String email;
    String username;
    String password;
    String il;
    String ilce;
    String mahalle;
    String sokak;
    String postakodu;
    String tcno;
    String dogumyeri;
    String medenihali;
    String meslek;
    String uyruk;
    boolean bildirimlerikapat;
    boolean aramalardagorunmesin;
    boolean hesaponaylandi;
}
