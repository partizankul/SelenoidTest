package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By logo = By.xpath("//a[@class=\"header-logo\"]");
    private By loginTextField = By.xpath("//input [@id=\"login_field\"]");
    private By passTextField = By.xpath("//input [@id=\"password\"]");
    private By singInBtn = By.xpath("//input [@class=\"btn btn-primary btn-block js-sign-in-button\"]");
    private By createAnAccountLink = By.xpath("//a[@data-ga-click=\"Sign in, switch to sign up\"]");
    private By loginOrPassError = By.xpath("//div[@class=\"flash flash-full flash-error \"]");

    public LoginPage clickLogo(){
        driver.findElement(logo).click();
        return this;
    }
    public LoginPage enterLogin(String login) {
        driver.findElement(loginTextField).sendKeys(login);
        return this;
    }
    public LoginPage enterPass(String pass) {
        driver.findElement(passTextField).sendKeys(pass);
        return this;
    }
    public LoginPage clickSingInBtn(){
        driver.findElement(singInBtn).click();
        return new LoginPage(driver);
    }
    public LoginPage clickCreateAnAccountLink(){
        driver.findElement(createAnAccountLink).click();
        return this;
    }
    public String getLoginOrPassError(){
        return driver.findElement(loginOrPassError).getText();
    }
    public LoginPage loginMetod(String login, String pass){
        this.enterLogin(login);
        this.enterPass(pass);
        clickSingInBtn();
        return new LoginPage(driver);
    }



}
