package tests.day15_SoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_PozitifLoginTesti {

    @Test
    public void test(){
        // 1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");
        // 2- login linkine basin
        QualityDemyPage qualityDemyPage=new QualityDemyPage();
        qualityDemyPage.ilkLoginLinki.click();

        qualityDemyPage.cookies.click();
        ReusableMethods.bekle(3);
        // 3- Kullanici email'i olarak valid email girin
        qualityDemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
        // 4- Kullanici sifresi olarak valid sifre girin
        qualityDemyPage.passwordKutusu.sendKeys("31488081");
        ReusableMethods.bekle(5);
        // 5- Login butonuna basarak login olun
        qualityDemyPage.loginButonu.click();
        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(qualityDemyPage.basariliGirisCoursesLinki.isDisplayed());

        Driver.closeDriver();
    }
}
