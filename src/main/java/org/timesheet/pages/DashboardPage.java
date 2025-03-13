package org.timesheet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage{
    private By sidebarPath = By.xpath("//nav[@aria-label='Sidepanel']");
    private By userOptionsPath = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private By logoutButtonPath = By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]");
    private By adminPageButtonPath = By.xpath("//nav//a[.='Admin']");
    private By timePageButtonPath = By.xpath("//nav//a[.='Time']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement getSidebar() {
        return driver.findElement(sidebarPath);
    }

    protected WebElement getAdminPageButton() {
        return driver.findElement(adminPageButtonPath);
    }

    protected WebElement getTimePageButton() {
        return driver.findElement(timePageButtonPath);
    }

    protected WebElement getUserOptionsButton() {
        return driver.findElement(userOptionsPath);
    }

    protected WebElement getLogoutButton() {
        return driver.findElement(logoutButtonPath);
    }
}
