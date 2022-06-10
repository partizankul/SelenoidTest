import Classes.MainPage;
import Utilites.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.module.Configuration;

public class TestMainPage {
    private MainPage mainPage;

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://github.com/");
        mainPage= new MainPage(Driver.getDriver());
    }
    @Test
    public void openSIteTest() {
        Driver.getDriver().get("https://github.com/");
    }

    @Test
    public void clickToLogo() {
        mainPage.clickLogo();
        Assert.assertEquals("https://github.com/", js.executeScript("return document.URL;").toString());
    }








//  @BeforeMethod
//  public void setUp(){

}

   /* @Test
    public void openSIteTest(){
        Driver.getDriver().get("https://github.com/");
    }


    @Test
    public void getURL(){
        System.out.println(js.executeScript("return document.URL;").toString());
    }*/