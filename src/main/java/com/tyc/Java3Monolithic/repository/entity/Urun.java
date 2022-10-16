package com.tyc.Java3Monolithic.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Table(name = "tblurun")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Urun extends Default {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String ad;
    String marka;
    String model;
    Double fiyat;
    Integer stok;

}
