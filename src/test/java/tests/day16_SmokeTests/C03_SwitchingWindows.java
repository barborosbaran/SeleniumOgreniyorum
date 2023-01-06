package tests.day16_SmokeTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_SwitchingWindows {
    @Test
    public void test(){

        //https://the-internet.herokuapp.com/iframe
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");

        //elementalselenium linkine tikla
        Driver.getDriver().findElement(By.linkText("Elemental Selenium")).click();
        // title title'i "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro"
        //// olan yeni window'a gecis yapin ve

        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");
        // sayfa uzerindeki h1 taginda elemental selenium yazdigini test edin

        String expectedYazi= "Elemental Selenium";
        String actualYazi=Driver.getDriver().findElement(By.tagName("h1")).getText();

        Assert.assertEquals(actualYazi,expectedYazi);
        Driver.getDriver().quit();
    }
}
