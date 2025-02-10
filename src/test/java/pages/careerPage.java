package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementHelper;

public class careerPage {
    WebDriver driver;
    ElementHelper elementHelper;

    public careerPage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
    }

    private static final By locationSlider = By.id("location-slider");
    private static final By findOurCalling = By.id("career-find-our-calling");
    private static final By lifeAtInsider = By.xpath("//*[@data-id='c06d1ec']");


    public void checkCareerPage() {
        elementHelper.verifyUrlContains("careers");
    }

    public void checkLocations() {
        elementHelper.verifyElementVisible(locationSlider);
    }

    public void checkTeams() {
        elementHelper.verifyElementVisible(findOurCalling);
    }

    public void checkLifeAtInsider() {
        elementHelper.verifyElementVisible(lifeAtInsider);
    }




}
