package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C06_WriteExcel {

  @Test
    public  void  test01() throws IOException {
     //ulkeler exceline 5.sutun(hucre) olarak NUFUS sutunu ekleyelim
     //3.satirdaki ulkenin nufusunu 1000000 yapalim

      /********1 dosyaya ulastik***********/
      String path="src/test/java/resources/ulkeler.xlsx";
      FileInputStream fis=new FileInputStream(path);

      /*******+2.class'da caslitirmak icin dosyanin bir kopyasi olan workbook olusturalim******/
      Workbook workbook= WorkbookFactory.create(fis);

      /************
      3.dosyada yapmak istedigimiz degisiklikleri kopya  workbook'da yapalim*/

      //ilk satirin 5.hucresine(sutun) NUFUS basligini yazdiralim
      workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");
      //+***createCell ile yeni sutun ekleriz belirttigimiz yere ve setCellValue ile basligini yollariz

      //3.satirdaki ulkenin nufusunu 1000000 yapalim

      workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1000000");


      //4 kopyada yaptigimiz degisiklikleri ana sayfaya kaydedelim

      FileOutputStream fos=new FileOutputStream(path);
      workbook.write(fos);

  }



}
