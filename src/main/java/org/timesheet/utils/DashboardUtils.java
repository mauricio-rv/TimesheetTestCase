package org.timesheet.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.timesheet.pages.DashboardPage;
import org.timesheet.pages.LoginPage;

import java.time.Duration;

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
