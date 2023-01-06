package tests.day14_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_HardAssert {

    //testNG de iki assert class i vardir
    //1. si Junit teki assert classi ile ayni methodlara sahiptir
    //ilk failed olan assert isleminde calismayi durdurur ve hata mesaji verir

    // 2. assert clasinin adi soft assert oldugu icicn ilkine hard assert denmistir.
    //2. asser classi ise soft assert class i dir
    // soft assert biz raporla deyinceye kadar assertionlari failed olsa bile calistirmaya devam eder
    // biz raporla dedigimizde calisan assertionlardan kacinin failed oldugunu soyler ve
    // failed olan assertion varsa raporla dedigimiz satirda calismayi durdurur


    @Test
    public void test01(){
        Assert.assertTrue(6>4);
        System.out.println("1. assert sonrasi");

        Assert.assertTrue(6>14);
        System.out.println("2. assert sonrasi");
        //assertion failed oldugundan bundan sonrasi 3. olan ignore edilir

        Assert.assertEquals(6,6);
        System.out.println("3. assert sonrasi");
    }
}
