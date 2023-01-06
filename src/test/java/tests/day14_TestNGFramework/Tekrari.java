package tests.day14_TestNGFramework;

public class Tekrari {
    /*
    1- (priority-depends on method)
    Driver class : PageObjectModel olusturacagimiz frame work de webDriver i
    driver classindaki getDriver methoduyla alacagiz
    getDriver() dan alacagiz istedigimiz zaman ve istedigimiz browaserdan
    driver classini biraz daha gelistirerek farkli browser lar ilede calisir hale gelecek

    2- Page classes: Surekli kullandigimiz locate islemlerini ve login gibi basit islevleri method halinde
    yapacagimiz methodlari page classinda olusturacagiz

    3- bir page class i olusturur olusturmaz ilk yapmamiz gereken ilk sey bir parametresiz constructor olusturup
    icinde pageFactory.inItElements(WebDriver,this) ile drivera page sayfasinda ilk deger atamasini (instantiate)
    yapmak olmalidir.

    4- Assertion : testNG de iki assertion yontemi vardir.
        = hard assert : Junit deki assert ile ayni methodlara sahiptir. ozelligi ilk failed olan assertion da
        calism,ayi durdurur ve rapor verir devam etmez.

        = soft assert : biz raporla diyene kadar assertionlar failed olsa bile calismaya devam eder. assertAll()
        ile raporlamasini istedigimizde failed ola assertion varsa raporlar ve calismayi durdurur.

    5- genelde test edin dendiginde hard assert
       dogrulayin verify denirse soft assert kullanilir.


     */
}
