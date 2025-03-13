package pageutils;

import org.openqa.selenium.WebDriver;
import pages.TimesheetPage;

public class TimeSheetUtils extends TimesheetPage {
    public TimeSheetUtils(WebDriver driver) {
        super(driver);
    }

    public boolean isTimeSheetPageDisplayed(){
        wait.until(d -> getTimesheetBody().isDisplayed());
        return true;
    }

    public boolean isAdminTimeSheetPageDisplayed(){
        wait.until(d -> getEmployeeInput().isDisplayed());
        return true;
    }

    public void searchEmployeeTimeSheet(String employeeName){
        getEmployeeInput().sendKeys(employeeName);
        wait.until(d -> getListbox().get(0).getText().equals(employeeName));
        getListbox().get(0).click();
        getViewEmployeeButton().click();
    }

    public boolean validateCommentAndApproved(String comment){
        wait.until(d -> getApproveInTable().isDisplayed());
        return getCommentInTable().getText().equals(comment);
    }

    public boolean addCommentAndApprove(String comment){
        wait.until(d -> getCommentBox().isDisplayed());
        getCommentBox().sendKeys(comment);
        getApproveButton().click();
        return validateCommentAndApproved(comment);
    }

    public void clickEditButton(){
        getEditButton().click();
    }

    public void submitAndWaitForActions(){
        getSubmitButton().click();
        wait.until(d -> getActionsPerformedTable().isDisplayed());
    }

    public boolean isTotalHoursCorrect(String totalHours){
        if(getTableTotal().getText().equals( totalHours))
            return true;
        return false;
    }
}
