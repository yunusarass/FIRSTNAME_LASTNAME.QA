package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementHelper extends DriverFactory {
    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    WebDriverWait shortWait;
    Scroll scrollDirector;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.shortWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        this.scrollDirector = new Scroll(driver);
    }

    public void verifyUrlContains(String text) {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    public WebElement findElement(By key) {
        try {
            try {
                return shortWait.until(ExpectedConditions.visibilityOfElementLocated(key));
            } catch (Exception e) {
                scrollDirector.findScrollPage(key);
                return shortWait.until(ExpectedConditions.visibilityOfElementLocated(key));
            }
        } catch (Exception e) {
            Assert.fail("Element not found");
        }
        return null;
    }

    public List<WebElement> findElements(By key) {
        try {
            findElement(key);
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
        }catch (Exception e) {
            System.out.println("Elements not found: " + e.getMessage());
            return null;
        }
    }

    public void verifyElementVisible(By key) {
        wait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }

    public void clickElement(By key) {
        wait.until(ExpectedConditions.elementToBeClickable(findElement(key))).click();
    }

    public int getElementsCount(By key) {
        try {
            List<WebElement> elements = findElements(key);
            return elements.size();
        }catch (Exception e) {
            System.out.println("Elements not found: " + e.getMessage());
            return 0;
        }
    }

    public WebElement getElementFromList(By key, int index) {
        return findElements(key).get(index);
    }

    public String getElementText(By key) {
        WebElement element = driver.findElement(key);
        return element.getText();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public WebElement getElementWithTextElements(By key, String text) {
        for (WebElement element : findElements(key)) {
            if(element.getText().equals(text)){
                return element;
            }
        }
        return null;
    }

    public void clickElementWithTextElements(By key, String text) {
        boolean check = false;
        for (WebElement element : findElements(key)) {
            if(element.getText().equals(text)){
                element.click();
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }
    public void moveToElement(By key) {
        action.moveToElement(scrollDirector.findScrollPage(key)).release().perform();
    }

    public void moveToElement(WebElement element) {
        action.moveToElement(element).release().perform();
    }

    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
