package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

  //bir page class actigimizda ilk yapamamiz ereken sey
    //parametresiz bir constructor olusturup
    //bu constructor icinde PageFactory ile driver'a ilk deger atamasi yapmak olmalodor
    public AmazonPage(){
         PageFactory.initElements(Driver.getDriver(),this);  //bizim driverimiz driver classs ta olustur ama onu burda kullanmamiz bunun sayesinde

    }

    @FindBy(id="twotabsearchtextbox")
     public WebElement amazonAramaKutusu;

    @FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small'")
    public  WebElement sonucYazisiElementi;



}
