package tests.day19_CrossBroweser;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C02_WisequarterTest extends TestBaseCross {
    @Test
    public void test01(){
        driver.get("https://www.wisequarter.com");
        String actualUrl= driver.getCurrentUrl();
        String expected ="wisequarter";
        Assert.assertTrue(actualUrl.contains(expected));
    }
}
