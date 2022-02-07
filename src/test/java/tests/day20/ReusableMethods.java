package tests.day20;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReusableMethods {

    //bir method olusturalim
    //dosya yolu ve satir,hucre indexini verince hucre bilgisini yazdirsin

    public static  Cell hucreGetir(String path, String sayfaIsmi, int satirIndex, int hucreIndex) throws FileNotFoundException {
        //return cell yazinca kabul etmedi bizde deger atadik ,cunku try catch arasinda dosya yolunu bulup cell
        // bulamazsam diyerek kabul etmedi bizde null atadik buraya
        Cell cell = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            cell = workbook.getSheet(sayfaIsmi).getRow(satirIndex).getCell(hucreIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cell;
    }

    public static  Map<String,String> mapOlustur(String path, String sayfaAdi) {

    Map<String,String> excelMap=new HashMap(); //map te key=value olarak calisir,excelde birini key yapip diger bilgilerini value yapabilirz

        //ilk Adim excelde istenen sayfaya  ulasmak

        Workbook workbook=null;  //deger atamayinca int kisiminda islem yapamadik workbook hata verdi
        try{
           FileInputStream fis=new FileInputStream(path);
            workbook=WorkbookFactory.create(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }


        int satirSayisi=workbook.getSheet(sayfaAdi).getLastRowNum();//getLastRow index veririr

        String key="";  //satir
        String value="";

        for (int i = 0; i <=satirSayisi ; i++) {
           //2.adim tablodaki hucreleri ma'e uygun hale donusturmek
           key=workbook.getSheet(sayfaAdi).getRow(i).getCell(0).toString();// stringe cevirdik
           //excel deki satirlarin ilkini alir
            value=workbook.getSheet(sayfaAdi).getRow(i).getCell(1).toString() + ", "+
                    workbook.getSheet(sayfaAdi).getRow(i).getCell(2).toString() + ", "+
                    workbook.getSheet(sayfaAdi).getRow(i).getCell(3).toString() ;
          //excelde 2,3,.. degerleri value olarak getirir
            // ucuncu adim key-value haline getirdigimiz satirlari map'e eklemek
            excelMap.put(key,value);


        }

        return excelMap;
//map yerine treemap yada ic ice for yapilabilir
    }
}






