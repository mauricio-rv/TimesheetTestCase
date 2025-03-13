package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage extends BasePage {
    private By addButtonPath = By.xpath("//button[text()=' Add ']");
    private By tablePath = By.xpath("//div[@class='oxd-table']//div[contains(text(),'Admin')]");
    private By tableUsersPath = By.xpath("//div[@class='oxd-table-card']/div/div[2]/div");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement getAddButton() {
        return driver.findElement(addButtonPath);
    }

    protected WebElement getTable() {
        return driver.findElement(tablePath);
    }

    protected List<WebElement> getUsersInTable() {
        return driver.findElements(tableUsersPath);
    }
}
