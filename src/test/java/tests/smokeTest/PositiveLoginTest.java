package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {

//1) com.techproed altinda bir package olustur : smoketest
//2) Bir Class olustur : PositiveTest


@Test
   public  void  positiveLoginTest(){
    //3) Bir test method olustur positiveLoginTest()
       //  https://www.hotelmycamp.com adresine git

 Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
 //		login linkine bas
 HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
 hotelMyCampPage.ilkLoginLinki.click();
 //test data username: manager ,
 hotelMyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
 //test data password : Manager1!
 hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
 hotelMyCampPage.loginButonu.click();
 //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
 Assert.assertTrue(hotelMyCampPage.basariliGirisYaziElementi.isDisplayed());

 Driver.closeDriver();


}

}
