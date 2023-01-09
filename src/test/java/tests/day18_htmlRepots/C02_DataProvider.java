package tests.day18_htmlRepots;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

    @DataProvider
    public static Object[][] AmazonAranacakKelimeler() {
        /*
        @DataProvider istedigimiz test metoduna test datasi saglamak icin kullanilir
        sadece 1 sarti vardir
        iki katli bir object arrayi dondurmelidir

         */

        Object[][] amazonAramacakKelimelerArrayi={{"nutella"},{"apple"},{"samsung"},{"armut"}};

        return amazonAramacakKelimelerArrayi;
    }

    //amazona gidelim
    //nutella, java, apple, samsung, armut kelimeleri icin arama yapalim
    //sonuclarin bu kelimeleri icerdigini test edlim

    @Test(dataProvider = "AmazonAranacakKelimeler")
    public void aramaTesti(String aranacakKelime){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);
        String actualSonucYazisi=amazonPage.amazonAramaSonucuElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(aranacakKelime));


    }
}
