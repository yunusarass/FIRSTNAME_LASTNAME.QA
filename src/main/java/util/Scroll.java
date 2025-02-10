package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public class Scroll {

    WebDriver driver;
    WebDriverWait wait;

    public Scroll(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, ofSeconds(1));
    }

    public WebElement findScrollPage(By key) {
        try {
            scrollDown();
            wait.until(ExpectedConditions.presenceOfElementLocated(key));
            return driver.findElement(key);
        } catch (Exception ignored) {
            scrollUp();
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
            return driver.findElement(key);
        }
    }

    public void scrollDown() {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 300).perform();
    }

    public void scrollUp() {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, -300).perform();
    }
}
