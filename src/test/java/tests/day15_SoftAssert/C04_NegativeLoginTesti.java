package tests.day15_SoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;

public class C04_NegativeLoginTesti {
    // 3 test method'u olusturun
    // 1.de yanlis email, dogru sifre
    // 2.de dogru email yanlis sifre
    // 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
    // giris yapilamadigini test edin
    QualityDemyPage qualitydemyPage= new QualityDemyPage();

    @Test(groups = "smoke")
    public void yanlisEmailTesti(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage.cookies.click();

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("mehmet@abc.com");
        qualitydemyPage.passwordKutusu.sendKeys("31488081");
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();
    }


    @Test
    public void yanlisPasswordTesti(){
        qualitydemyPage= new QualityDemyPage();
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage.cookies.click();

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
        qualitydemyPage.passwordKutusu.sendKeys("123456");
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();

    }


    @Test
    public void yanlisEmailYanlisPasswordTesti(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage.cookies.click();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("mehmet@abc.com");
        qualitydemyPage.passwordKutusu.sendKeys("123456");
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();
    }
}
