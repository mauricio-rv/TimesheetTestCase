package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EditTimeSheetPage extends BasePage {
    private By activityInputPath = By.xpath("//div[@class='oxd-select-text-input']");
    private By allInputsPath = By.xpath("//form//td//input");
    private By submitButtonPath = By.xpath("//button[text()=' Save ']");
    private By listboxPath = By.xpath("//div[@role='listbox']//div");

    public EditTimeSheetPage(WebDriver driver) {
        super(driver);
    }

    protected List<WebElement> getAllInputs() {
        return driver.findElements(allInputsPath);
    }

    protected List<WebElement> getListbox() {
        return driver.findElements(listboxPath);
    }

    protected WebElement getActivityInput() {
        return driver.findElement(activityInputPath);
    }

    protected WebElement getSubmitButton() {
        return driver.findElement(submitButtonPath);
    }
}
