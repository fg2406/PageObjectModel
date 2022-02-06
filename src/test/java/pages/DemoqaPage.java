package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoqaPage {



    public  DemoqaPage(){

        PageFactory.initElements(Driver.getDriver(),this);


    }
  @FindBy(xpath = "//div[@class='rt-tr']")
    public WebElement baslikSatiriElementi;


  @FindBy(xpath = "//div[@class='rt-resizable-header-content']")
  public List<WebElement> basliklarWebelementListesi ;

  @FindBy(xpath = "//div[@class='rt-tbody']")
    public  WebElement bodyWebelemet;

  @FindBy(xpath = "//div[@class='rt-td'] ")
    public  List<WebElement> tumDataWebelementList;

  @FindBy (xpath = "//div[@class='rt-tr-group']")
    public  List<WebElement> tumSatirlarWebelementList;


    public void sutunYazdir(int sutun) {

        System.out.println(basliklarWebelementListesi.get(sutun-1).getText()); //bunu yazmasakta olur,bu header basligini getirir,extra yazdik
        int satirSayisi=tumSatirlarWebelementList.size();


        WebElement geciciElement;  //locate edecegimiz webElemement
        String dinamikXpath;      //biz string dondursuk istiyoruz,getText() ile

        for (int i=1;i<=satirSayisi;i++){   //listeden almayak 1'den baslayacak

        dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+sutun+"]";
        geciciElement=Driver.getDriver().findElement(By.xpath(dinamikXpath));

        System.out.println(geciciElement.getText());

    }}

    public void ismeGoreMaasYazdir(String isim) {

      int satirSayisi= tumSatirlarWebelementList.size();  //satir sayisini bilmeye ithtiyacimiz var for icinde o kadar gezmesi icin

      String dinamikXpath;
      String satirdakiIsim;
      String salary;   //maas demek

        for (int i=1 ;i<=satirSayisi ; i++){  //i satirlari tek tek tarayacak, sayilarini tek tek dondurcek,i listen gelmiyor

            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+1+"]";  //i.satirdaki 1.isimi getirir
           satirdakiIsim=Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();

            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+5+"]";  //i.satirin 5.datasini alir,5.data hep maas zaten
            salary=Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();   //maasi aldik


          if (satirdakiIsim.equals(isim)){
              System.out.println(salary);
            }

        }

    }

    public void hucreYazdir(int satir,int sutun) {

    String dinamikXpath= dinamikXpath="((//div[@class='rt-tr-group'])["+satir+"]//div[@class='rt-td'])["+sutun+"]";
        System.out.println(Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText());


    }
}
