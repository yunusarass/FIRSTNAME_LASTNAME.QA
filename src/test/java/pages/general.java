package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementHelper;

public class general {
    ElementHelper elementHelper;
    private static final By cookiebutton = By.id("wt-cli-accept-all-btn");
    public general(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }
    public void clickAllowCookies() {
        elementHelper.clickElement(cookiebutton);
    }
    public void goToUrl(String url){
        elementHelper.navigateToUrl(url);
    }
    public void switchToNewTab() {
        elementHelper.switchToNewTab();
    }

}
