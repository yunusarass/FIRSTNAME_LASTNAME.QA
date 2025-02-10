package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementHelper;

public class qualityAssurancePage {

    WebDriver driver;

    ElementHelper elementHelper;

    public qualityAssurancePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }


    private static final By seeAllQAJobs = By.cssSelector(".button-group.d-flex.flex-row");


    public void checkSeeAllQAJobs() {
        elementHelper.verifyElementVisible(seeAllQAJobs);
    }

    public void clickSeeAllQAJobs() {
        elementHelper.clickElement(seeAllQAJobs);
    }









}
