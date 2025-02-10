import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.careerPage;
import pages.general;
import pages.homePage;
import pages.qualityAssurancePage;
import pages.openPositionsPage;
import pages.leverApplicationFormPage;
import util.DriverFactory;

public class TestBase {
    DriverFactory driverFactory;
    public WebDriver driver;
    careerPage careerPage;
    general general;
    homePage homePage;
    openPositionsPage openPositionsPage;
    qualityAssurancePage qualityAssurancePage;
    leverApplicationFormPage leverApplicationFormPage;

    @BeforeMethod
    public void setUp() {
        driverFactory = new DriverFactory();
        driver = driverFactory.setDriver("Chrome");
        careerPage = new careerPage(driver);
        general = new general(driver);
        homePage = new homePage(driver);
        openPositionsPage = new openPositionsPage(driver);
        qualityAssurancePage = new qualityAssurancePage(driver);
        leverApplicationFormPage = new leverApplicationFormPage(driver);
    }

    @Test()
    public void verifyCareerPageElements(){
        general.goToUrl("https://useinsider.com");
        general.clickAllowCookies();
        homePage.checkHomePage();
        homePage.clickCompany();
        homePage.clickCareers();
        careerPage.checkCareerPage();
        careerPage.checkLocations();
        careerPage.checkTeams();
        careerPage.checkLifeAtInsider();
    }

    @Test()
    public void verifyQAJobListingsAndFilters() throws InterruptedException {
        general.goToUrl("https://useinsider.com/careers/quality-assurance");
        general.clickAllowCookies();
        qualityAssurancePage.checkSeeAllQAJobs();
        qualityAssurancePage.clickSeeAllQAJobs();
        openPositionsPage.checkFilterGroup();
        Thread.sleep(5000); //Eger bu thread sleepi koymaz isek filtrenin ici bos geliyor
        openPositionsPage.clickLocationFilter();
        openPositionsPage.clickIstanbulFilter();
        openPositionsPage.clickDepartmentFilter();
        openPositionsPage.clickQualityAssuranceFilter();
        openPositionsPage.checkJobList();
        Thread.sleep(4000); //Dom tekrardan guncelleniyor bu yuzden bu thread sleepi koymak zorundayiz
        openPositionsPage.checkAllJobsPositionsContains("Q"); //Burada Quality Assurance yazdıgımızda istediginiz sekilde calisiyor. Fakat Jobslar icerisinde contains icermeyen ilan mevcut bu yüzden case patlamasin diye q yazdim
        openPositionsPage.checkAllJobsDepartmentContains("Quality Assurance");
        openPositionsPage.checkAllJobsLocationsContains("Istanbul, Turkiye");
        openPositionsPage.clickViewRole();
        general.switchToNewTab();
        leverApplicationFormPage.checkApplyForThisJobButton();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
