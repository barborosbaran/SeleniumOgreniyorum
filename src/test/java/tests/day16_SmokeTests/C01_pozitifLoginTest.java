package tests.day16_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_pozitifLoginTest {

    @Test
    public void pozitifLoginTest(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));


        QualityDemyPage qualityDemyPage=new QualityDemyPage();
        qualityDemyPage.cookies.click();
        ReusableMethods.bekle(3);
        qualityDemyPage.ilkLoginLinki.click();
        qualityDemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualityDemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qualityDemyPage.loginButonu.click();

        Assert.assertTrue(qualityDemyPage.basariliGirisCoursesLinki.isDisplayed());


        ReusableMethods.bekle(3);
        Driver.closeDriver();

    }


}
