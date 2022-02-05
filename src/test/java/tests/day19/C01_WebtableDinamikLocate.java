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
    //3.Method: sutun numarasi verdigimde bana tum sutunu yazdirsin

    HMCWebTablePage hmcWebTablePage;
    HotelMyCampPage hotelMyCampPage;


    @Test
    public void saytirYAzdirTesti(){

        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
    //1.Method: satir numarasi verdigimde bana o satirdaki datalari yazdirsin

    //2.satiri yazdir //tbody//tr[2]   bburda degisen sadece numaralar bu yuzden dinamik yaptik
    //7.satiri yazdir //tbody//tr[7]
    hmcWebTablePage=new HMCWebTablePage();
    WebElement ucuncuSatirElementi= hmcWebTablePage.satirGetir(3);
        System.out.println(ucuncuSatirElementi.getText());
        Driver.closeDriver();

}


   @Test
   public  void  hucreGetirTesti(){

        hotelMyCampPage.girisYap();
       //2.Method: satir ve data numarasi girdigimde, verdigim datayi yazdirsin
        hmcWebTablePage=new HMCWebTablePage();

        //2.satirin 4.datasi //tbody//tr[2]//td[4]
       //4.satirin 5.datasi  //tbody//tr[4]//td[5]

       System.out.println("girdiginiz hucredeki elementb :"+ hmcWebTablePage.hucreWebelementGetir(3,5));
       Driver.closeDriver();

   }





}
