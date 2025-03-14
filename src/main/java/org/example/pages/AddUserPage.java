package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddUserPage extends BasePage {
    private By saveButtonPath = By.xpath("//div[@class='oxd-form-actions']/button[2]");
    private By selectRoleAndStatusPath = By.xpath("//div[@class='oxd-select-wrapper']");
    private By employeeInputPath = By.xpath("//input[@placeholder='Type for hints...']");
    private By listboxPath = By.xpath("//div[@role='listbox']/div");
    private By usernameInputPath = By.xpath("//div[.='Username']//input");
    private By passwordAndConfirmPasswordPath = By.xpath("//input[@type='password']");
    private By saveButton = By.xpath("//button[@type='submit']");

    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement getSaveButton() {
        return driver.findElement(saveButtonPath);
    }

    protected List<WebElement> getSelectRoleAndStatus() {
        return driver.findElements(selectRoleAndStatusPath);
    }

    protected WebElement getEmployeeInput() {
        return driver.findElement(employeeInputPath);
    }

    protected List<WebElement> getListbox() {
        return driver.findElements(listboxPath);
    }

    protected WebElement getUsernameInput() {
        return driver.findElement(usernameInputPath);
    }

    protected List<WebElement> getPasswordAndConfirmPassword() {
        return driver.findElements(passwordAndConfirmPasswordPath);
    }

    protected WebElement getSaveButtonElement() {
        return driver.findElement(saveButton);
    }
}
