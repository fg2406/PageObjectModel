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
  HotelMyCampPage hotelMyCampPage;
  HMCWebTablePage hmcWebTablePage;
  @Test
    public  void satirYazdir(){
      hotelMyCampPage=new HotelMyCampPage();
      hotelMyCampPage.girisYap();
      //1.Method: satir numarasi verdigimde bana o satirdaki datalari yazdirsin
   hmcWebTablePage.satirGetir(3);

      Driver.closeDriver();
  }


  @Test
    public  void  datayiYazdir(){
      hotelMyCampPage=new HotelMyCampPage();
      hotelMyCampPage.girisYap();
      hmcWebTablePage.hucreWebelementGetir(3,5);
      Driver.closeDriver();


  }

  @Test
    public  void  sutunYazdir(){
      hotelMyCampPage=new HotelMyCampPage();
      hotelMyCampPage.girisYap();
      hmcWebTablePage.sutunYazdir(3);



  }



}
