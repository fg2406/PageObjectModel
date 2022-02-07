package tests.day20;

import org.apache.poi.ss.usermodel.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01ReadExcel {

@Test
    public void test01() throws IOException {

    String path="src/test/java/resources/ulkeler.xlsx";
    FileInputStream fis=new FileInputStream(path);

    Workbook workbook= WorkbookFactory.create(fis);  //bizim excel dosyamiz
    Sheet sheet= workbook.getSheet("Sayfa1");   //her acik excel sekmesi
    Row row= sheet.getRow(4);   //row satir demek
    Cell cell= row.getCell(2);   //bu cell objesi,data turu Cell(hucre)
    System.out.println(cell);  //tabloda sayim index'e gore sayar verir

    //index'i 4 olan satirdaki,indexi 2olan hucrenin Andorra oldugunu test ediniz

    String expectedData="Andorra";
    Assert.assertEquals(cell.getStringCellValue(),expectedData);  //bilgiler ayni olsada data turleri farkli
    //bu yuzden cell'i de String yaptik hata duzeldi


    //5.index'teki satirin,3.index deki hucre bilgisini yazdiralim

    row= sheet.getRow(5);   //satiri getirir
    cell= row.getCell(3);   //hucre bilgisi getirir

    System.out.println(cell);

}


}
