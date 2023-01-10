package tests.day19_CrossBroweser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossDriver;
import utilities.TestBaseCross;

public class C01_AmazonSearch extends TestBaseCross {
    @Test
    public void test01(){
        //amazon anasayfaya gidelim

        driver.get(ConfigReader.getProperty("amazonUrl"));

        //nutella icin arama yapalim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //sonuclarin nutella icerdigini test edelim
        WebElement sonucYazi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
         String actual=sonucYazi.getText();
         String expected="Nutella";
        Assert.assertTrue(actual.contains(expected));

    }

}
