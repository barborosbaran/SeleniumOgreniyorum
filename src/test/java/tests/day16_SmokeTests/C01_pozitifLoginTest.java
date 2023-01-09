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


            // qualitydemy anasayfaya git
            Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

            QualityDemyPage qualitydemyPage= new QualityDemyPage();
            qualitydemyPage.ilkLoginLinki.click();
        if (qualitydemyPage.cookies.isDisplayed()){
            qualitydemyPage.cookies.click();
        }

            qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
            qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

            qualitydemyPage.loginButonu.click();

            ReusableMethods.bekle(2);


            Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());
            Driver.closeDriver();
        }


}
