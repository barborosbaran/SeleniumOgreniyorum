package tests.day16_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02NegatifLoginTesti {

    // 3 test method'u olusturun
// 1.de yanlis email, dogru sifre
// 2.de dogru email yanlis sifre
// 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
// giris yapilamadigini test edin

    QualityDemyPage qualityDemyPage=new QualityDemyPage();

    @Test
    public void yanlisEmailTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualityDemyPage.cookies.click();
        qualityDemyPage.ilkLoginLinki.click();
        qualityDemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualityDemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qualityDemyPage.loginButonu.click();

        Assert.assertTrue(qualityDemyPage.kullaniciEmailKutusu.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.closeDriver();

    }

    @Test
    public void yanlisPaswordTesti(){

        qualityDemyPage=new QualityDemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualityDemyPage.ilkLoginLinki.click();
        qualityDemyPage.ilkLoginLinki.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualityDemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualityDemyPage.loginButonu.click();

        Assert.assertTrue(qualityDemyPage.ilkLoginLinki.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.closeDriver();

    }

    @Test
    public void yanlisEmailYanlisPasswordTest(){
        qualityDemyPage=new QualityDemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualityDemyPage.ilkLoginLinki.click();
        qualityDemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualityDemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualityDemyPage.loginButonu.click();

        Assert.assertTrue(qualityDemyPage.ilkLoginLinki.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.closeDriver();

    }
}
