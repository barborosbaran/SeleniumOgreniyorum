package tests.day15_SoftAssert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C02_SoftAssert {
    @Test
    public void test(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        ZeroWebAppPage zeroWebAppPage=new ZeroWebAppPage();
        zeroWebAppPage.signInButton.click();

        // 3. Login kutusuna “username” yazin
        zeroWebAppPage.usernameKutusu.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        zeroWebAppPage.passwordKutusu.sendKeys("password");

        // 5. Sign in tusuna basin
        zeroWebAppPage.submitButonu.click();
        Driver.getDriver().navigate().back();

        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        //Driver.getDriver().switchTo().alert().accept();

        zeroWebAppPage.onlineBanking.click();
        zeroWebAppPage.paybillLinki.click();

        // 7. “Purchase Foreign Currency” tusuna basin
        zeroWebAppPage.puchaseButton.click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        Select select= new Select(zeroWebAppPage.currencyDropDown);
        select.selectByVisibleText("Eurozone (euro)");

        // 9. soft assert kullanarak “Eurozone (euro)” secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String actualDropDownSecim=select.getFirstSelectedOption().getText();
        String expectedDropDownSecim="Eurozone (euro)";

        softAssert.assertEquals(actualDropDownSecim,expectedDropDownSecim, "Eurozone secilmedi");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // “Select One”, “Australia (dollar)“, “Canada (dollar)“,”Switzerland (franc)“,”China (yuan)“,
        // ”Denmark (krone)“,”Eurozone (euro)“,”Great Britain (pound)“,”Hong Kong (dollar)“,”Japan (yen)“,
        // ”Mexico (peso)“,”Norway (krone)“,”New Zealand (dollar)“,”Sweden (krona)“,”Singapore (dollar)“,
        // ”Thailand (baht)”

        List<WebElement> optionsElemenListesi=select.getOptions();

        List<String> actualOptionsListesiStr=new ArrayList<>();

        for (WebElement each: optionsElemenListesi
             ) {
            actualOptionsListesiStr.add(each.getText());
        }

    String[] arr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
    List<String> expectedOptionsListesi= Arrays.asList(arr);
        Collections.sort(actualOptionsListesiStr);
        Collections.sort(expectedOptionsListesi);
        softAssert.assertEquals(actualOptionsListesiStr,expectedOptionsListesi);



        ReusableMethods.bekle(3);
        softAssert.assertAll();
        Driver.getDriver().close();

    }
}
