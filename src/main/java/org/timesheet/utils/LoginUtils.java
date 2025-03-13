package org.timesheet.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.timesheet.pages.BasePage;
import org.timesheet.pages.LoginPage;

import java.time.Duration;

public class LoginUtils extends LoginPage{

    public LoginUtils(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPageLoaded() {
        wait.until(d-> getLoginButton().isDisplayed());
        return true;
    }

    public void login(String username, String password) {
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }
}
