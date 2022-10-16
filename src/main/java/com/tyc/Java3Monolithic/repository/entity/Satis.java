package com.tyc.Java3Monolithic.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Table(name = "tblsatis")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Satis extends Default {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    Long musterid;
    Long urunid;
    Double adet;
    Double fiyat;
    Double toplamfiyat;
    Long tarih;


}
