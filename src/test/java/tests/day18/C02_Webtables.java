package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;
import utilities.Driver;

import java.util.List;

public class C02_Webtables {

    HotelMyCampPage hotelMyCampPage;
    HMCWebTablePage hmcWebTablePage;
    @Test
    public void loginT(){
        //● Bir class oluşturun : C02_WebTables
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //          ○ Username : manager
        //          ○ Password : Manager1!
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
    }
    @Test (dependsOnMethods = "loginT")
    public void table(){
        //table( ) metodu oluşturun
         //tum table (sutun sayisi)bulun.
        //header kisminda birinci satir ve altindaki datalari locate edelim
        ////thead//tr[1]//th
      hmcWebTablePage=new HMCWebTablePage();
      List<WebElement> headerDataList=hmcWebTablePage.headerBirinciSatirDatalar;
        System.out.println(hmcWebTablePage.headerBirinciSatirDatalar.size()+"sutun sayisi");

        //          ○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        //       //tbody
        System.out.println(hmcWebTablePage.tumBodyWebElementi.getText());

        // Eger body'yi tek bir webelement olarak locate edersek
        // icindeki tum datalari getText() ile yazdirabiliriz
        // ancak bu durumda bu elementler ayri ayri degil,
        // body'nin icindeki tek bir String'in parcalari olurlar
        // dolayisiyla bu elementlere tek tek ulasmamiz mumkun olmaz
        // sadece contains method'u ile body'de olup olmadiklarini test edebiliriz.
        // eger her bir datayi ayri ayri almak istersek
        //  //tbody//td seklinde locate edip bir list'e atabiliriz

    }
    @Test (dependsOnMethods = "loginT")
    public void printRows(){
        //● printRows( ) metodu oluşturun //tr
        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        // //tbody//tr

        List<WebElement> tableBodyToplamSatir=hmcWebTablePage.satirlarListesi;
        System.out.println(tableBodyToplamSatir.size()+"table body 'sinde bulunan toplam satir sayisi");

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        List<WebElement> tableBodySatirlar=hmcWebTablePage.satirlarListesi;
        for (WebElement each:tableBodySatirlar
             ) {
            System.out.println(each.getText());
        }

        //4.satirdaki(row) elementleri konsolda yazdırın.
        //tbody//tr[4]
        System.out.println(tableBodySatirlar.get(3).getText()+"4.satir elementleri");  //index 0 dan baslar 4.satir icin 3.index aldik
    //tablo 1.basliyor evet ama biz hepsini liste koydugumuz icin list te index 0'dan baslar,biz listeden cagiriyoruz
      Driver.closeDriver();

    }


}


