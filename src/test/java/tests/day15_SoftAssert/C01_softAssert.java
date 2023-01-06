package tests.day15_SoftAssert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_softAssert {

    @Test
    public void test01(){

        // amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");

        //amazon anasayfaya gittiginizi dogrulayin
        SoftAssert softAssert=new SoftAssert();
        String expectedURLKelime="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedURLKelime),"anasayfaya gidemediniz");

        //nutella aratin
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //arama sonuclarinin nutella icerdigini dogrulayin
        String aramasonucYazisi=amazonPage.amazonAramaSonucuElementi.getText();
        softAssert.assertTrue(aramasonucYazisi.contains("Nutella"),"arama sonucu NUtella icermiyor");

        ReusableMethods.bekle(1);

        //java aratin
        amazonPage.amazonAramaKutusu.clear();
        amazonPage.amazonAramaKutusu.sendKeys("Java"+Keys.ENTER);

        //arama sonuclarinin >1000 oldugunu dogrulayin
        //System.out.println(amazonPage.amazonAramaSonucuElementi.getText());
        //1-48 of over 6,000 results for "Java"

        aramasonucYazisi=amazonPage.amazonAramaSonucuElementi.getText();

        String[] sonucArr=aramasonucYazisi.split(" ");
       // System.out.println(Arrays.toString(sonucArr)); [1-48, of, over, 6,000, results, for, "Java"]

        String javaSonucsayisiStr=sonucArr[3];// 6,000
        javaSonucsayisiStr=javaSonucsayisiStr.replaceAll("\\W",""); //6000
        //System.out.println(javaSonucsayisiStr);

        int sonucSayisiInt=Integer.parseInt(javaSonucsayisiStr);

        softAssert.assertTrue(sonucSayisiInt>1000, "java icin arama sonucu 1000 den buyuk degil");



        softAssert.assertAll();
        Driver.closeDriver();

    }
}
