package org.example.pageutils;

import org.openqa.selenium.WebDriver;
import org.example.pages.LoginPage;

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
