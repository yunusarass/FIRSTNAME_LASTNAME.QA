package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory{

    public WebDriver driver;

    public WebDriver setDriver(String browser){
        if(browser.equals("Firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
        }else if (browser.equals("Safari")) {
            driver = new SafariDriver();
        }else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return driver;
    }

    public WebDriver getDriver(){
        return driver;
    }


}
