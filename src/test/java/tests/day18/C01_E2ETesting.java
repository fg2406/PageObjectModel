package tests.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_E2ETesting{
   //. Tests packagenin altına class olusturun: CreateHotel
    //2. Bir metod olusturun: createHotel


 @Test
    public  void  createHotel(){
     //3. https://www.hotelmycamp.com adresine git.
     //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
     //    a. Username : manager
     //    b. Password  : Manager1!
     //5. Login butonuna tıklayın.
     HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
     hotelMyCampPage.girisYap();


     //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
     hotelMyCampPage.bekle(3);
     hotelMyCampPage.hotelManagementLinki.click();
     hotelMyCampPage.hotelListLinki.click();
     hotelMyCampPage.addHotelLinki.click();

     //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
     Actions actions=new Actions(Driver.getDriver());
     Faker faker=new Faker();

     //8. Save butonuna tıklayın.
     //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
     //10. OK butonuna tıklayın.




 }

}
