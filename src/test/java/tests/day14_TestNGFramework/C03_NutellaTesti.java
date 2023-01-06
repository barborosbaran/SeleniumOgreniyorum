package tests.day14_TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C03_NutellaTesti {

    @Test
    public void test01(){
        //amazon ana sayfaya gidin nutella icin arama yapin sonuclarin nutella icerdigini test edin

        Driver.getDriver().get("https://www.amazon.com");
       // WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //WebElement sonucElementi=Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualKelime=amazonPage.amazonAramaSonucuElementi.getText();

        Assert.assertTrue(actualKelime.contains(expectedKelime));


        Driver.closeDriver();

    }
}
