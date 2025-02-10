package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementHelper;

public class homePage {

    ElementHelper elementHelper;

    public homePage(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }


    private static final By homePage = By.cssSelector(".home-page");
    private static final By company = By.id("navbarDropdownMenuLink");
    private static final By companyDropdown = By.cssSelector(".new-menu-dropdown-layout-6-left-container");
    private static final By careersLink = By.xpath("//a[contains(@class, 'dropdown-sub') and text()='Careers']");


    public void checkHomePage(){
        elementHelper.verifyElementVisible(homePage);
    }
    public void clickCompany() {
        elementHelper.clickElementWithTextElements(company, "Company");
        elementHelper.verifyElementVisible(companyDropdown);
    }
    public void clickCareers() {
        elementHelper.clickElement(careersLink);
    }

}
