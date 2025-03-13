package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By usernameFieldPath = By.name("username");
    private By passwordFieldPath = By.name("password");
    private By loginButtonPath = By.xpath("//button[text()=' Login ']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement getUsernameField() {
        return driver.findElement(usernameFieldPath);
    }

    protected WebElement getPasswordField() {
        return driver.findElement(passwordFieldPath);
    }

    protected WebElement getLoginButton() {
        return driver.findElement(loginButtonPath);
    }
}
