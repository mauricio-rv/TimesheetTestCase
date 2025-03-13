package pageutils;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

public class DashboardUtils extends DashboardPage{

    public DashboardUtils(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardPageLoaded(){
        wait.until(d -> getSidebar().isDisplayed());
        return true;
    }

    public void goToAdminPage(){
        getAdminPageButton().click();
    }

    public void goToTimePage(){
        getTimePageButton().click();
    }

    public void logout(){
        getUserOptionsButton().click();
        wait.until(d -> getLogoutButton().isDisplayed());
        getLogoutButton().click();
    }
}
