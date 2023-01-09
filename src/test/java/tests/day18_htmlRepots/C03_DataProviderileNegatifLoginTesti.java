package tests.day18_htmlRepots;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderileNegatifLoginTesti {

   // @DataProvider
  //  public static String[] AmazonAranacakKelimeler() {

   //     String[] amazonAranacakKelimelerArrayi = {"Nutella", "Java", "Apple", "Samsung", "armut"};

   //     return amazonAranacakKelimelerArrayi;
  //  }


    @DataProvider
    public static Object[][] kullaniciBilgileri() {

        Object[][] kullaniciBilgileriARR={{"A11","A12345"},{"B12","B12345"},{"C13","C12345"},{"D14","D12345"},{"E15","E12345"}};
        return kullaniciBilgileriARR;
    }


    //Qualitydemy anasayfaya gidin
    //verilen yanlis kullanici adi ve password kombinasyonlari icin giris yapilamadigini test edin
    //username      password
    // A11          A12345
    //B12           B12345
    //C13           C12345
    //D13           D12345
    //E15           E12345

    @Test(dataProvider = "kullaniciBilgileri")
    public void negatifLoginTest(String username, String password){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualityDemyPage qualityDemyPage=new QualityDemyPage();
        qualityDemyPage.ilkLoginLinki.click();
        qualityDemyPage.kullaniciEmailKutusu.sendKeys(username);
        qualityDemyPage.passwordKutusu.sendKeys(password);
        qualityDemyPage.loginButonu.click();

        Assert.assertTrue(qualityDemyPage.kullaniciEmailKutusu.isDisplayed());


    }


}
