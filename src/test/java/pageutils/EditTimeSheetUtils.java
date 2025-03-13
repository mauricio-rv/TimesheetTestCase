package pageutils;

import org.openqa.selenium.WebDriver;
import pages.EditTimeSheetPage;

public class EditTimeSheetUtils extends EditTimeSheetPage {
    public EditTimeSheetUtils(WebDriver driver) {
        super(driver);
    }

    public void fillTimeSheetData(String projectName, String dailyHours) {
        wait.until(d -> getActivityInput().isDisplayed());

        getAllInputs().get(0).sendKeys(projectName);
        wait.until(d -> getListbox().get(0).getText().equals("ACME Ltd - ACME Ltd"));
        getListbox().get(0).click();

        getActivityInput().click();
        wait.until(d -> !getListbox().get(0).getText().equals("No Records Found"));
        getListbox().get(2).click();

        getAllInputs().get(1).sendKeys(dailyHours);
        getAllInputs().get(2).sendKeys(dailyHours);
        getAllInputs().get(3).sendKeys(dailyHours);
        getAllInputs().get(4).sendKeys(dailyHours);
        getAllInputs().get(5).sendKeys(dailyHours);

        getSubmitButton().click();
    }
}
