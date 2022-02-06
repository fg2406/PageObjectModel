package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_WebtableDinamikLocate {

     //3 test method'u olusuralim
    //1.Method: satir numarasi verdigimde bana o satirdaki datalari yazdirsin
    //2.Method: satir ve data numarasi girdigimde, verdigim datayi yazdirsin
    //3.sutun numarasi verdigimde bana tum sutunu yazdirin

HMCWebTablePage hmcWebTablePage;
HotelMyCampPage hotelMyCampPage;
   @Test
    public  void  satirYazdirTesti(){
       hotelMyCampPage=new HotelMyCampPage();
       hotelMyCampPage.girisYap();

       //1.Method: satir numarasi verdigimde bana o satirdaki datalari yazdirsin
       //2.satiri yazdir   //tbody//tr[2]
       //7.satiri yazdir   //tbody//tr[7]


       hmcWebTablePage=new HMCWebTablePage();
       WebElement ucuncusatirElementi=hmcWebTablePage.satirGetir(3);
       System.out.println(ucuncusatirElementi.getText());  //getText ile yazdirabilirz
       Driver.closeDriver();

   }

  @Test
   public void hucreGetirTesti(){

      hotelMyCampPage=new HotelMyCampPage();
      hotelMyCampPage.girisYap();
      //2.Method: satir ve data numarasi girdigimde, verdigim datayi yazdirsin(yazdirsin dedigi icin atama yapmaya gerek yok)
      hmcWebTablePage=new HMCWebTablePage();


      //2.satirin(tr=row=satir) 4.datasi(hucre,datalar=td)  //tbody//tr[2]//td[4]
      //4.satirin 5.datasi           //tbody//tr[4]//td[5]

      System.out.println(hmcWebTablePage.hucreWebelementGetir(3,5)+"girdiginiz hucrenin datalari");  //method coll yaparak method olusturduk

   }

   @Test
    public  void  sutunYazdirTest(){

       hotelMyCampPage=new HotelMyCampPage();
       hotelMyCampPage.girisYap();
       //3.sutun numarasi verdigimde bana tum sutunu yazdirin
       hmcWebTablePage=new HMCWebTablePage();
       hmcWebTablePage.sutunYazdir(4);

   }
}
