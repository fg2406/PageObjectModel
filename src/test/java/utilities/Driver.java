package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {



    public static WebDriver driver;

   public static WebDriver  getDriver(){
       WebDriverManager.chromedriver().setup();
      /*if icine sarti koymasak her bu method cagirildiginda new celisir ve yeni bir browser acilir.cunku bir her isimizi artik kendi
      * olusturdugumuz getDriver methodu cagirarak yapacagiz.Eger driver bos degilse new(yeni) browser acma devam et,yok bossa ici nullsa yani bir
      * browser ac demek   */

       if(driver==null){
           driver=new ChromeDriver();
       }

       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    return  driver;
   }

  public  static  void  closeDriver(){
     if(driver!=null){   //eger driver icinde birsey varsa yani bos(null) degilse
         driver.quit();    // o var olanlari sil
         driver=null;    //eger driver ici bos ise kapatma
     }





  }

}
