package tests.day18_htmlRepots;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_HTML_Reports extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest=extentReports.createTest("Nutella testi","Kullanici amazonda nutella arayabilmeli");

    //amazona git nutella arat sonuclarin nutella icerdigini test et
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon ana sayfaya gidildi");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("Arama kutusuna Nutella yazip arama yapildi");
        String actualSonucYazisi=amazonPage.amazonAramaSonucuElementi.getText();
        String expectedKelime="Nutella";
        extentTest.info("arama sonuclari kaydedildi");
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        extentTest.pass("Arama sonuclarinin Nutella icerdigi test edildi");
    }
}
