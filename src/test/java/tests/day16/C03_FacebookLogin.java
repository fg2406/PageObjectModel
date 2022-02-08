package tests.day16;

import com.github.javafaker.Faker;
import org.checkerframework.common.util.report.qual.ReportWrite;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_FacebookLogin {



     @Test(groups = "miniRegression,smoke")
    public  void  test01(){
         //1 - https://www.facebook.com/ adresine gidin
         Driver.getDriver().get("https://www.facebook.com/");

         //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
         Faker faker=new Faker();
         //4- Basarili giris yapilamadigini test edin

     }

}
