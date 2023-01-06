package tests.day14_TestNGFramework;

import org.testng.annotations.Test;

public class C01_TestNGilkTest {

    /*
    TestNG methodlarini isim sirasina gore calisir
    priority degeri verilen methodlar priority degeri kucukten buyuge dogru calisir
    esit olan priority de harf sirasina bakilir
    eger priority degeri yazmazsak priority=0 kabul eder
     */
    @Test(priority = 6)
    public void ilkTest(){
        System.out.println("ilk test calisti");
    }
    @Test(priority = 9)
    public void ikinciTest(){
        System.out.println("ikinci test calisti");
    }
    @Test(priority = -5)
    public void ucuncuTest(){
        System.out.println("ucuncu test calisti");
    }
}
