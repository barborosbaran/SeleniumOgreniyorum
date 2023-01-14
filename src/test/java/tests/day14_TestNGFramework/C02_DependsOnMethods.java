package tests.day14_TestNGFramework;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    @Test
    public void ilkTest(){

        System.out.println("ilk test calisti");
    }
    @Test(dependsOnMethods = "ilkTest")
    public void ikinciTest(){

        System.out.println("ikinci test calisti");
    }
    @Test(dependsOnMethods = "ikinciTest")
    public void ucuncuTest(){

        System.out.println("ucuncu test calisti");
    }

}
