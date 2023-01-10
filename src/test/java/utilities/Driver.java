package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    //driver class indan driveri get driver methodu  ile kullaniyoruz
    //sonradan projeye katilan insanlarin driver classinda obje olusturarak driver kullanmaya
    // calismalarini engellemek icin driver classini SINGLETON PATTAER ile duzenleyebiliriz

    private Driver(){
        //constructorunu gorunur yaptik ve private hale getirerek obje olusturulmasini onledik
    }

    static WebDriver driver;

    public static WebDriver getDriver() {


        String browser = ConfigReader.getProperty("browser"); //ayakci

        if (driver == null) {

            switch (browser) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }
}
