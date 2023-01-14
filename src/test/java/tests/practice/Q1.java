package tests.practice;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Q1 extends TestBaseRapor {
    // Amazon anasayfaya gidip search textboxta
    // elma, armut, portakal aratalim

    @DataProvider
    public Object[][] arancakKelimeler(){

        Object[][] kelime = {{"elma"},{"armut"},{"portakal"}};

        return kelime;
    }



    @Test (dataProvider = "arancakKelimeler")
    public void a_anasayfayaGidis(String urun){
        ReusableMethods.bekle(3);
        // amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");
        // nutella icin arama yapin
        //WebElement aramaKutusu= Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        AmazonPage amazonPage= new AmazonPage();

        amazonPage.amazonAramaKutusu.sendKeys(urun + Keys.ENTER);
    }

    @DataProvider
    public Object[][] login(){

        Object[][] usernamePassword = new Object[3][2];

        usernamePassword[0][0]="qdGecerliUsername";
        usernamePassword[0][1]="qdGecersizPassword";
        usernamePassword[1][0]="qdGecersizUsername";
        usernamePassword[1][1]="qdGecerliPassword";
        usernamePassword[2][0]="qdGecersizUsername";
        usernamePassword[2][1]="qdGecersizPassword";

        return usernamePassword;
    }

    @Test(dataProvider = "login")
    public void Test01Login(String userName, String password){
        extentTest=extentReports.createTest("Negatif login testi","kullanici yanlis bilgilerle giris yapamamali");

        QualityDemyPage qualityDemyPage= new QualityDemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("QualityDemy ana sayfaya gidildi");
        qualityDemyPage.ilkLoginLinki.click();
        extentTest.info("Login linki tiklandi");

        qualityDemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty(userName));
        extentTest.info("email girisi yapildi");

        qualityDemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty(password));
        extentTest.info("password girisi yapildi");

        Assert.assertTrue(qualityDemyPage.kullaniciEmailKutusu.isDisplayed());
        extentTest.pass("giris yapilamadigi test edildi");
    }

}


