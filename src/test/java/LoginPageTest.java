import Classes.LoginPage;

import Utilites.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {
    private LoginPage loginPage;
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://github.com/login");
        loginPage = new LoginPage(Driver.getDriver());
    }

    @Test
    public void clickToLogo(){
        loginPage.clickLogo();
        Assert.assertEquals("https://github.com/", js.executeScript("return document.URL;").toString());
    }
    @Test
    public void loginTest(){
        loginPage.loginMetod("loggg", "Passss");
        Assert.assertEquals("Incorrect username or password.", loginPage.getLoginOrPassError());
    }
    @Test
    public void clickToCreatLink(){
        loginPage.clickCreateAnAccountLink();
        Assert.assertEquals("https://github.com/signup?source=login", js.executeScript("return document.URL;").toString());
    }

}
