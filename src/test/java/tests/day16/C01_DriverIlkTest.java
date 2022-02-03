package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverIlkTest {



    //Driver class sayesinde bizim eski driver'i kullanmayacagiz
    //arttik driver'a ihtiyac varsa Driver.gerDriver() yazacagiz
@Test
    public  void  test01(){
    //amazon'a gidelim
    Driver.getDriver().get("https://www.amazon.com");

    //ve gittigimizi test edelim
    String actualTitel=Driver.getDriver().getTitle();
    String actualUrl=Driver.getDriver().getCurrentUrl();
    Assert.assertTrue(actualTitel.contains("Amazon"));

    // Driver.getDriver() method'u her calistiginda
    // driver = new ChromeDriver(); komutundan oturu yeni bir driver olusturuyor
    // Biz Driver class'dan getDriver()'i ilk calistirdigimizda new atamasi olsun
    // sonraki calismalarda atama olmasin istiyoruz
    // bunun icin driver = new ChromeDriver(); satirni bir if blogu icine aliriz

   Driver.closeDriver();  //methodu burda birkez cagirdik bos degilse olan driver kapat,bossa tamamen kapatma



}


@Test
    public  void  test02(){
    Driver.getDriver().get("https://www.bestbuy.com");

    //bestBuy gittigimizi test edelim
    String actualUrl=Driver.getDriver().getCurrentUrl();
    Assert.assertTrue(actualUrl.contains("best"));

     Driver.closeDriver();  //bunu yazmazsan kapatmaz,close methodunu cagirmmadik

}

}
