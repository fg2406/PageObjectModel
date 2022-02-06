package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class C02_WebtableDemoqa {






   //Bir Class olusturun D19_WebtablesHomework

    @Test
    public  void  demoqaTest(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
       Driver.getDriver().get(ConfigReader.getProperty("DemoqaUrl"));

        //  2. Headers da bulunan department(baslik) isimlerini yazdirin
        //  //thead//th normalde bu sekilde olurde farkli birsey yoksa html icinde,bakilmasi gerekir
        //bu tablo class isimleri iler organize edilmis

        DemoqaPage demoqaPage=new DemoqaPage();
        System.out.println("baslik satiri elementi  :"+demoqaPage.baslikSatiriElementi.getText());

        //  3. sutunun basligini yazdirin
        System.out.println("3.sutunun basligini yazdirin :"+demoqaPage.basliklarWebelementListesi.get(2));

        //  4. Tablodaki tum datalari yazdirin
        System.out.println("*****************tum body*******************");
        System.out.println("tablodaki tum datalar :"+demoqaPage.bodyWebelemet.getText());

        //  5. Tabloda kac cell (data) oldugunu yazdirin

        System.out.println("Tablodali data sayisi "+demoqaPage.tumDataWebelementList.size());

        //  6. Tablodaki satir sayisini yazdirin
        System.out.println("Tablodaki satir sayisi :"+demoqaPage.tumSatirlarWebelementList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        //1.yol:bu farkli yollardan hesaplanabilir,hucre sayisi/satir sayisi yapilabilir
       //tum datalarin toplam sayisinin bolumu tum satirlarin sayisina bolumu sutunu veriri
        System.out.println("tablodaki sutun sayisi :"
                       +demoqaPage.tumDataWebelementList.size()/demoqaPage.tumSatirlarWebelementList.size());

         //2.yol
        System.out.println("tablodaki sutun sayisi :"+demoqaPage.basliklarWebelementListesi.size());


        //  8. Tablodaki 3.kolonu yazdirin

        demoqaPage.sutunYazdir(2);

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary(maas)'sini yazdirin
        demoqaPage.ismeGoreMaasYazdir("Kierra");

        //demoqaPage.ismeGoreMaasYazdir("Kierra");
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        demoqaPage.hucreYazdir(3,2);
        Driver.closeDriver();
    }

}
