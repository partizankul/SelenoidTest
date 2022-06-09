package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By logo = By.xpath("//a[@class=\"mr-4 color-fg-inherit\"]");
    private By signInLink = By.xpath("//a[@href=\"/login\"]");
    private By signUpLink = By.xpath("//a[@class=\"HeaderMenu-link flex-shrink-0 d-inline-block no-underline border color-border-default rounded px-2 py-1\"]");

    public MainPage clickLogo(){
        driver.findElement(logo).click();
        return this;
    }
    public MainPage clickSignInLink(){
        driver.findElement(signInLink).click();
        return new MainPage(driver);
    }

    public MainPage clickSignUpLink(){
        driver.findElement(signUpLink).click();
        return new MainPage(driver);
    }


}
