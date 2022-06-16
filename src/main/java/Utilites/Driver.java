package Utilites;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

public class Driver {
    private static RemoteWebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){
        if(driver ==null){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "101.0");
     //       ChromeOptions options = new ChromeOptions();
      //     options.addArguments("start-maximized");
      //      capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", false
            ));
            try {
                driver = new RemoteWebDriver(
                        URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                        capabilities
                ); return driver;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }return driver;
    }
}
