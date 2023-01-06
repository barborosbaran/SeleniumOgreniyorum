package tests.day14_TestNGFramework;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C05_SoftAssert {
    @Test
    public void test(){
        // 1. adim softassert objesi olusturmak
        SoftAssert softAssert= new SoftAssert();

        //2, adim soft asser objesini kullanarak assertionlari yapin
        softAssert.assertEquals(6,8);
        System.out.println("1. assertion");

        softAssert.assertTrue(5>3);
        System.out.println("2. assertion");

        softAssert.assertFalse(8>5);
        System.out.println("3. assertion");

        //3. adim soft assert e raporla diyecegiz

        softAssert.assertAll();
        //bu satirda calisma durur cunku failed olan assertion var
        System.out.println("assertiAll()");
    }
}
