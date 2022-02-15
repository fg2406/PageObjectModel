package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class TestBaseRapor {

    protected static ExtentReports extentReports; //extent report'a ilk atamayi yapar
    protected static ExtentTest extentTest; // test pass veya failed gibi bilgileri kaydeder. Ayrica ekran resmi icin de kullaniriz
    protected static ExtentHtmlReporter extentHtmlReporter; // Html raporu duzenler
    // Test işlemine başlamadan hemen önce (test methodundan önce değil, tüm test işleminden önce)

   //before method ihtiyacimiz yok,driver ayarlari icin kullaniyorduk onu zaten driver de yaptik

    @BeforeTest(alwaysRun = true) // alwaysRun : her zaman çalıştır.
    public void setUpTest() {
        extentReports = new ExtentReports();  //Raporlamayi baslatir,yukarda ilk deger verdik burda atadik
        //rapor oluştuktan sonra raporunuz nereye eklensin istiyorsanız buraya yazıyorsunuz.
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/Rapor"+date+".html";

        //buraya kopyalanacak,dinamik bizede uyar,+ san sonraki kisimini uymazsa bilgis.kendimiz path alip koyariz
        //oluşturmak istediğimiz raporu (html formatında) başlatıyoruz, filePath ile dosya yolunu belirliyoruz.

        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);



        // İstediğiniz bilgileri buraya ekeyebiliyorsunuz.!!!!!!!bu kismi kendine gore ayarla
        extentReports.setSystemInfo("Enviroment","QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox vs.
        extentReports.setSystemInfo("Automation Engineer", "Mehmet");
        extentHtmlReporter.config().setDocumentTitle("son test");
        extentHtmlReporter.config().setReportName("TestNG raporlar");
    }



    // Her test methodundan sonra eğer testte hata varsa, ekran görüntüsü alıp rapora ekliyor
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) { // eğer testin sonucu başarısızsa
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // eğer test çalıştırılmadan geçilmezse
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore olanlar
        }
        Driver.closeDriver();
    }


    // Raporlandırmayı sonlandırmak icin


    @AfterTest(alwaysRun = true) //butun class,dukkan calisti en son bu kapatir,test altindaki pages vs.kapatur.)
    public void tearDownTest() {
        extentReports.flush();
    }
}


