package com.tyc.Java3Monolithic.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Table(name = "tblmusteri")
@Entity
@Data // Getter-Setter
@AllArgsConstructor // Parametreli constructor
@NoArgsConstructor // Default constructor
//@Builder // Builder pattern
@SuperBuilder
public class Musteri extends Default {
    /**
     * Tum property'lerin getter ve setter'lari eklenmeli
     * Parametreli ve parametresiz constructor eklenmeli
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String ad;
    String soyad;
    String adres;
    String telefon;
    int dogumtarihi;
    String email;
    String username;
    String psw;

}
