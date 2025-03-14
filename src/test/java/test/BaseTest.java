package test;

import org.example.pageutils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    private String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    protected WebDriver driver;
    protected LoginUtils loginUtils;
    protected DashboardUtils dashboardUtils;
    protected AdminUtils adminUtils;
    protected AddUserUtils addUserUtils;
    protected TimeSheetUtils timeSheetUtils;
    protected EditTimeSheetUtils editTimeSheetUtils;

    @BeforeSuite
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(baseURL);
        loginUtils = new LoginUtils(driver);
        dashboardUtils = new DashboardUtils(driver);
        adminUtils = new AdminUtils(driver);
        addUserUtils = new AddUserUtils(driver);
        timeSheetUtils = new TimeSheetUtils(driver);
        editTimeSheetUtils = new EditTimeSheetUtils(driver);
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
