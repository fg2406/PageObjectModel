package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class C05_ExceliMapeYukleme {

   @Test
    public  void  test01(){

       //dosya yolu ve sayfa ismi verilen bir excel sheet'i map olarak kaydeden
       //reusable bir method olusturalim
      String path="src/test/java/resources/ulkeler.xlsx";
      String sayfaAdi="Sayfa1";

       //System.out.println(ReusableMethods.mapOlustur(path,sayfaAdi));  //bu sekilde hersey gelir tablodan
       //key value olarak,Benin=Porto Novo, Benin, Porto Novo ...

       Map<String,String> ulkelerMap=ReusableMethods.mapOlustur(path,sayfaAdi);

       //olusturdugumuz map'i kullanarak Germany'in bilgilerini yazdirin
       System.out.println(ulkelerMap.get("Almanya"));

       // Listede Netherlands oldugunu testedin

       Assert.assertTrue(ulkelerMap.containsKey("Netherlands"));

   }


}
