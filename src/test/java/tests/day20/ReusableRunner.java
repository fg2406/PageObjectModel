package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ReusableRunner {

@Test
    public  void test01() throws FileNotFoundException {

    //ulkeler excelin deki,sayfa1'de
    //11.index'deki satirin,2.index'indeki hucresinin Azerbaycan oldugunu test edin

    String path = "src/test/java/resources/ulkeler.xlsx";
    String expectedData = "Azerbaycan";
    String actualData = ReusableMethods.hucreGetir(path, "Sayfa1", 11, 2).toString();
    Assert.assertEquals(actualData, expectedData);


}
}





