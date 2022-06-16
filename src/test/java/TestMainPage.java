import Classes.MainPage;
import Utilites.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestMainPage {
    private MainPage mainPage;

     JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://github.com/");
        mainPage= new MainPage(Driver.getDriver());
    }
    @Test
    public void clickToLogo(){
        mainPage.clickLogo();
        Assert.assertEquals("https://github.com/", js.executeScript("return document.URL;").toString());
    }

    @Test
    public void clickSignInButton(){
        mainPage.clickSingInButton();
        Assert.assertEquals("https://github.com/login", js.executeScript("return document.URL;").toString());
    }

    @Test
    public void clickSignUpButton(){
        mainPage.clickSingUpButton();
        Assert.assertEquals("https://github.com/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home", js.executeScript("return document.URL;").toString());
    }




}




