package tests.day17;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PropertiesIlkClass {

@Test
    public  void  positiveLoginTesti(){

    //Hotel My camp sitesine positive login testini POM' tam uygun olarak yapiniz

    //https://www. hotelmycamp.com/ adresine git
    Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

    // login butonuna bas
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
    hotelMyCampPage.ilkLoginLinki.click();

    // test data username: manager ,
    hotelMyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));

    // test data password : Manager1!
    hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
    hotelMyCampPage.bekle(3);
    hotelMyCampPage.loginButonu.click();

    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    Assert.assertTrue(hotelMyCampPage.basariliGirisYaziElementi.isDisplayed());
     Driver.closeDriver();



}

}





