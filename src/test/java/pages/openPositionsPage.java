package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.ElementHelper;

public class openPositionsPage {

    WebDriver driver;
    ElementHelper elementHelper;

    public openPositionsPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    private static final By filterGroup = By.id("top-filter-form");
    private static final By locationFilter = By.id("select2-filter-by-location-container");
    private static final By filterOption = By.cssSelector(".select2-results__option");
    private static final By departmentFilter = By.id("select2-filter-by-department-container");
    private static final By jobList = By.id("jobs-list");
    private static final By positionsName = By.cssSelector(".position-title.font-weight-bold");
    private static final By departmentName = By.cssSelector(".position-department.text-large.font-weight-600.text-primary");
    private static final By locationsName = By.cssSelector(".position-location.text-large");
    private static final By viewRole = By.cssSelector(".btn.btn-navy.rounded.pt-2.pr-5.pb-2.pl-5");


    public void checkFilterGroup() {
        elementHelper.verifyElementVisible(filterGroup);
    }

    public void clickLocationFilter() {
        elementHelper.clickElement(locationFilter);
    }

    public void clickIstanbulFilter() {
        elementHelper.clickElementWithTextElements(filterOption, "Istanbul, Turkiye");
    }

    public void clickDepartmentFilter() {
        elementHelper.clickElement(departmentFilter);
    }

    public void clickQualityAssuranceFilter() {
        elementHelper.clickElementWithTextElements(filterOption, "Quality Assurance");
    }

    public void checkJobList() {
        elementHelper.verifyElementVisible(jobList);
    }

    public void checkAllJobsPositionsContains(String text) {
        for(var i =0 ; i<elementHelper.getElementsCount(positionsName) ; i++){
            Assert.assertTrue(elementHelper.getElementFromList(positionsName,i).getText().contains(text));
        }
    }

    public void checkAllJobsDepartmentContains(String text) {
        for(var i =0 ; i<elementHelper.getElementsCount(departmentName) ; i++){
            Assert.assertTrue(elementHelper.getElementFromList(departmentName,i).getText().contains(text));
        }
    }

    public void checkAllJobsLocationsContains(String text) {
        for(var i =0 ; i<elementHelper.getElementsCount(locationsName) ; i++){
            Assert.assertTrue(elementHelper.getElementFromList(locationsName,i).getText().contains(text));
        }
    }

    public void clickViewRole() {
        elementHelper.moveToElement(viewRole);
        elementHelper.clickElement(viewRole);
    }







}
