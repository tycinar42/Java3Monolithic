package com.tyc.Java3Monolithic.repository;

import com.tyc.Java3Monolithic.repository.entity.Musteri;
import com.tyc.Java3Monolithic.repository.entity.view.VwMusteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * !!!DIKKAT!!!
 * Bu interface bir repository sinifidir. Bu nedenle Spring siniflari analiz ederken
 * uzerinde bulunan annotation'lara bakarak onlarin instance'larini olusturur.
 * Buraya mutlaka @Repository annotation'ini eklemeyi unutma
 */
@Repository
public interface IMusteriRepository extends JpaRepository<Musteri, Long> {

    /**
     * !!!DIKKAT!!!
     * Repository siniflari icinde sorgu yazmak icin ozel kelimeleri kullaniliriz
     * 1- find : kelimesi yazilir
     * 2- By : ne icin arayacagimizi belirtir. Kullanacagimiz entity property'sinin adini yazariz
     * 3- [entity -> degiskenadi] : entity degisken adini yazariz (ilk harfi buyuk digerleri entitydeki yazildigi gibi
     * 4- method eger parametre aliyorsa yazilan metne uygun bir degisken talep edilir(TYPE). Talep edilen degiskenin
     * adi onemli degildir. ...(String username)
     * 5- Method'un geri donus tipini belirtiriz.
     */

    // select * from tblmusteri where username = ?
    Musteri findByUsername(String username);
    // select * from tblmusteri where adres = ?
    List<Musteri> findByAdres(String adres);

    /**
     * Dogum tarihi belli bir tarihten buyuk alanlari getir
     * GreaterThan
     * LessThan
     * select * from tblmusteri where dogumtarihi > ?
     */

    List<Musteri> findByDogumtarihiGreaterThan(int dogumtarihi);
    /**
     * Adinda belli bir karakter aranilan kisileri getirir.
     * selec * from tblmusteri where ad like '%?%'
     */
    List<Musteri> findAllByAdLike(String ad);

    /**
     * ad ve adresi a ile baslayanlar
     * select * from tblmusteri where ad like 'a%' and adres like 'a%'
     */

    List<Musteri> findAllByAdStartingWith(String ad);

    /**
     * and ile birlestirdigimiz sorgularda degiskenlerin sirasi onemlidir. Spring yazilan siraya gore
     * sorguyu yapar
     *
     * List<Musteri> findAllByAdStartingWith  And  AdresStartingWith(String ad, String adres);
     * and öncesi ad degiskenini alir, sonrasi adres degiskenini
     *
     */
    List<Musteri> findAllByAdStartingWithAndAdresStartingWith(String ad, String adres);

    /**
     * Sorgularimiz bize her zaman sonuc donmez bu nedenle null gelen sonuclar da alabiliriz
     * Optional almaliyiz
     * findOptionalBy...
     */

    Optional<Musteri> findOptionalByUsername(String username);
    Optional<List<Musteri>> findAllOptionalByAdres(String adres);

    /**
     * ASC -> A...Z
     * DESC -> Z...A
     */
    List<Musteri> findByDogumtarihiOrderByDogumtarihi(int dogumtarihi);
    List<Musteri> findByDogumtarihiOrderByDogumtarihiDesc(int dogumtarihi);
    Musteri findTopByDogumtarihiOrderByDogumtarihiDesc(int dogumtarihi); // sadece 1 kayit getirir

    /**
     * ONEMLI!!!
     * Eger sorgumuz birden fazla kayit donuyorsa tekli sonuc yazmamaliyizç
     * CompilerTime da sorun olmaz ama kullanirken hata aliriz
     */
    List<Musteri> findTop3ByDogumtarihiOrderByDogumtarihiDesc(int dogumtarihi); // Ilk 3 kaydi getirir
    Optional<List<Musteri>> findOptionalTop3ByDogumtarihiOrderByDogumtarihiDesc(int dogumtarihi); // Ilk 3 kaydi getirir. Optional

    /**
     * select * from tblmusteri where dogumtarihi > ? and dogumtarihi < ?
     */
    List<Musteri> findAllByDogumtarihiBetween(int baslangic, int bitis);
    List<Musteri> findAllByAdresAndDogumtarihiBetween(String adres, int baslangic, int bitis);

    /**
     * 1- aktif olan musterileri getir
     */
//    Optional<List<Musteri>> findAllOptionalByIsactive(boolean isactive); // true-false
//    Optional<List<Musteri>> findAllOptionalByIsactiveTrue(); // aktif kayitlar
//    Optional<List<Musteri>> findAllOptionalByIsactiveFalse(); // pasif kayitlar

    /**
     * 2- id sini verdigim musteriyi bul
     */

    Optional<Musteri> findOptionalById(Long id);

    /**
     * 3- ad ve soyadına gore ara ad ve soyad buyuk-kucuk harf duyarli olmasin
     */
    Optional<List<Musteri>> findAllOptionalByAdAndSoyad(String ad, String soyad);
    Optional<List<Musteri>> findAllOptionalByAdAndSoyadIgnoreCase(String ad, String soyad);

    /**
     * 4- cep telefonu 555 ile baslayanlari getir
     * 555XXXXXX
     */
    Optional<List<Musteri>> findAllOptionalByTelefonStartingWith(String telefon);

    /**
     * 5- XXX555XXXX
     */
    Optional<List<Musteri>> findAllOptionalByTelefonContaining(String telefon);

    /**
     * 6- mail adresi gmail olan Ankrali listesi
     * ...Containing ile yaparsak @gmail gibi arama yapilabilir
     */

    Optional<List<Musteri>> findAllOptionalByEmailEndingWithAndAdres(String email, String adres);

    /**
     * Kelime bazli sorgularin yetersiz kaldigi durumlarda JPQL, HQL ya da NATIVESQL yazabiliriz
     *
     * JPQL
     */
    @Query("select m from Musteri m where m.email = ?1")
    Musteri senBulEmailAdresineGore(String email);

    @Query("select mst from Musteri mst where mst.ad = ?1 and mst.soyad = ?2")
    Musteri bulAdSoyad(String ad, String soyad);

    /**
     * Native SQL kullanimi
     * NOT: Tablo adiyla sorgu yapilir
     */
    @Query(value = "select * from tblmusteri where email = ?1", nativeQuery = true)
    List<Musteri> getirEmailAdresineGore(String email);

    /**
     * Parametreyi belirterek sorgu yapmak
     * findByAdAndEmail("yasin", "yasin@gmail.com")
     * select * from tblmusteri where email = 'yasin@gmail.com' and ad = 'yasin'
     */
//    @Query("Select m from Musteri m where m.email = ?1 and m.ad = ?2")
    @Query("Select m from Musteri m where m.email = :paramemail and m.ad = :paramad")
    Musteri findByAdAndEmail(
            @Param("paramad") String musteriAdi,
            @Param("paramemail") String musteriEmaili
    );

    @Query("select " +
            "new com.tyc.Java3Monolithic.repository.entity.view.VwMusteri(m.id, m.ad, m.soyad) " +
            "from Musteri m")
    List<VwMusteri> findAllView();

    Musteri findByUsernameAndPsw(String username, String psw);
    Optional<Musteri> findOptionalByUsernameAndPsw(String username, String psw);

    /**
     * Muhammet -> muhammet
     * @param username
     * @param password
     * @return
     */
    @Query("select COUNT(m)>0 from Musteri m where UPPER(m.username)=UPPER(?1) and m.psw=?2")
    Boolean isExistMusteri(String username,String password);

}
