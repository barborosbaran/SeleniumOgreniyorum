package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebAppPage {

    public ZeroWebAppPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement usernameKutusu;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submitButonu;

    @FindBy(xpath = "//Strong[text()='Online Banking']")
    public WebElement onlineBanking;

    @FindBy(xpath = "//span[@id='pay_bills_link']")
    public WebElement paybillLinki;

    @FindBy(xpath = "//a[@href='#ui-tabs-3']")
    public WebElement puchaseButton;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropDown;
    // public List aaaaa; finElements


}
