package com.tyc.Java3Monolithic.constants;

public class EndPoints {
    /**
     * DIKKAT!!!
     * Uygulama ile alakali tum IRL listesini buraya ekleyip buradan kullanmaliyiz
     */

    /**
     * http://localhost:9090/mkv1
     */
    public static final String VERSION = "/mkv1";

    /**
     * http://localhost:9090/mkv1/web
     * http://localhost:9090/mkv1/api
     */
    public static final String WEB = "/web";
    public static final String API = "/api";

    /**
     * Tum Controller siniflari icin End Point listesi
     * http://localhost:9090/mkv1/api/satis
     * http://localhost:9090/mkv1/api/urun
     * http://localhost:9090/mkv1/api/musteri
     */
    public static final String SATIS = "/satis";
    public static final String URUN = "/urun";
    public static final String MUSTERI = "/musteri";

    /**
     * Uygulama icinde default olarak kullanilan tum end pointlerin
     * listesini ekleriz
     */

    public static final String SAVE = "/save";
    public static final String SAVEALL = "/saveall";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String GETALL = "/getall";
    public static final String GETBYID = "/getbyid";
    public static final String FINDALL = "/findall";
    public static final String FINDBYID = "/findbyid";

    /**
     * MUSTERI ISLEMLERI  END POINTLERI
     */

    public static final String FINDBYNAMEANDSURNAME = "/findbynameandsurname";

    /**
     * URUN ISLEMLERI END POINTLERI
     */

    public static final String URUN_SAVE_DTO = "/urunsavedto";


}
