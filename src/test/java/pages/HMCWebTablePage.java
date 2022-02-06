package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HMCWebTablePage {

  public HMCWebTablePage(){
    PageFactory.initElements(Driver.getDriver(),this);

   }





    @FindBy (xpath = "//thead//tr[1]//th")
    public List<WebElement> headerBirinciSatirDatalar;
    //bir eleman dondersede findBy ile cok donsede,elemet-elements gibi ayrimi yok,biz test kisminda ayrim yapariz

    @FindBy(xpath = "//tbody")
    public WebElement tumBodyWebElementi;


    @FindBy(xpath = "//tbody//td")
    public List<WebElement> tumBodyDatalariList;

    @FindBy(xpath = "//tbody//tr ")
    public List<WebElement> satirlarListesi;


    @FindBy(xpath = "//tbody//tr[4]//td")
   public  List<WebElement> dorduncuSatirElementi;



 public WebElement satirGetir(int satirNo){
  // 2.satiri yazdir  //tbody//tr[2]  //2 ve 7 disinda hersey ayni bu yuzden dinamik yaptik
  // 7.satiri yazdir //tbody//tr[7]

  String satirDinamikXpath= "//tbody//tr["+ satirNo +"]";
  WebElement satirElementi=Driver.getDriver().findElement(By.xpath(satirDinamikXpath));  //eski usul yaptik locate,finbay yapmadik
 //tek bir element oldugu icin element(elements degil)

  return satirElementi;



 }


 public String hucreWebelementGetir(int satir, int sutun) {
    //datalar icin String daha uygun

    //2.satirin(tr=row=satir) 4.datasi(hucre,datalar=td)  //tbody//tr[2]//td[4]
    //4.satirin 5.datasi           //tbody//tr[4]//td[5]

    String dinamikHucreXpath="//tbody//tr["+ satir +"]//td["+ sutun +"]";
   WebElement istenenHucreElementi=Driver.getDriver().findElement(By.xpath(dinamikHucreXpath));
   String hucreDatasi=istenenHucreElementi.getText();

   return hucreDatasi;

 }

    public void sutunYazdir(int sutun) {
    //herbir satirdaki istenen sutun   elementini yazdirabilmek icin
        //once satir sayisini bilmek lazim

     int satirSayisi= satirlarListesi.size(); //satirlar saysini getirir
       for (int i=1 ;i<=satirSayisi ;i++){     //her bir satir for icinde doner
           System.out.println(hucreWebelementGetir(i,sutun));    //1.satir,4.sutun,2.satir 4.sutun ...seklinde gider

            //bur methodla istenen sutundaki tum elementleri getirir


        }

 }
}
