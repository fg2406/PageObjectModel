package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageIlkClass {


   //POM'de farkli class'lara farkli sekilde ulasilmasi benimsenmistir
    //driver class'i icin static yontemi kullaniyoruz
    //page class'lari icin ise obje uzerinden kullanilmasi tercih edilmistir


        @Test
        public void test01(){

            //amazona git
            Driver.getDriver().get("http://www.amazon.com");

            //arama kutusuna Nutella yaz ve arat.
            AmazonPage amazonPage= new AmazonPage();
            amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);

            //arama sonuclarinin Nutella cerdigini test et.
            String actualSonucStr= amazonPage.sonucYazisiElementi.getText();

            Driver.closeDriver();


    }

  @Test
    public  void  test02(){
      //amazon'a gidelim
      Driver.getDriver().get("https://www.amazon.com");
      //java aramasi yapalim
      AmazonPage amazonPage=new AmazonPage();
      amazonPage.amazonAramaKutusu.sendKeys("java");
      //sonucun java icerdigini test edelim
      String SonucYazisi1=amazonPage.sonucYazisiElementi.getText();
      Assert.assertTrue(SonucYazisi1.contains("java"+Keys.ENTER));
    Driver.closeDriver();

  }

}
