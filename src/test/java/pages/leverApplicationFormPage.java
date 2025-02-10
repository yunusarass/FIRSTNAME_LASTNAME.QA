package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementHelper;

public class leverApplicationFormPage {

    WebDriver driver;

    ElementHelper elementHelper;

    public leverApplicationFormPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    private static final By applyForThisJobButton = By.cssSelector(".postings-btn.template-btn-submit.shamrock");


    public void checkApplyForThisJobButton() {
        elementHelper.verifyElementVisible(applyForThisJobButton);
    }


}
