package Utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

public class Driver {
    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){
        if(driver ==null){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "101.0");
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", false
            ));
            try {
                RemoteWebDriver driver = new RemoteWebDriver(
                        URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                        capabilities
                ); return driver;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }return driver;
    }

    public static void close(){
        driver.close();
        driver=null;
    }

}
