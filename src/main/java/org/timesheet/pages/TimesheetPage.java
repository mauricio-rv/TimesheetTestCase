package org.timesheet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TimesheetPage extends BasePage{
    private By timesheetBodyPath = By.xpath("//div[@class='orangehrm-timesheet-body']");
    private By editButtonPath = By.xpath("//form//button[.=' Edit ']");
    private By submitButtonPath = By.xpath("//form//button[.=' Submit ']");
    private By tableTotalPath = By.xpath("//tr[@class='orangehrm-timesheet-table-body-row --total']/td[10]");
    private By actionsPerformedTablePath = By.xpath("//h6[contains(.,'Actions Performed on the Timesheet')]");

    private By employeeInputPath = By.xpath("//input[@placeholder='Type for hints...']");
    private By viewEmployeeButtonPath = By.xpath("//button[@type='submit']");
    private By listboxPath = By.xpath("//div[@role='listbox']//div");
    private By commentBoxPath = By.xpath("//textarea[@placeholder='Type here ...']");
    private By approveButtonPath = By.xpath("//button[text()=' Approve ']");
    private By approveInTablePath = By.xpath("//div[@class='oxd-table-body']//div[contains(text(),'Approved')]");
    private By commentInTablePath = By.xpath("//div[@class='oxd-table-body']/div[2]//div[4]//span");

    public TimesheetPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement getEmployeeInput() {
        return driver.findElement(employeeInputPath);
    }

    protected WebElement getViewEmployeeButton() {
        return driver.findElement(viewEmployeeButtonPath);
    }

    protected List<WebElement> getListbox() {
        return driver.findElements(listboxPath);
    }

    protected WebElement getCommentBox() {
        return driver.findElement(commentBoxPath);
    }

    protected WebElement getApproveButton() {
        return driver.findElement(approveButtonPath);
    }

    protected WebElement getApproveInTable() {
        return driver.findElement(approveInTablePath);
    }

    protected WebElement getCommentInTable() {
        return driver.findElement(commentInTablePath);
    }

    protected WebElement getEditButton(){
        return driver.findElement(editButtonPath);
    }

    protected WebElement getSubmitButton(){
        return driver.findElement(submitButtonPath);
    }

    protected WebElement getTimesheetBody(){
        return driver.findElement(timesheetBodyPath);
    }

    protected WebElement getTableTotal(){
        return driver.findElement(tableTotalPath);
    }

    protected WebElement getActionsPerformedTable(){
        return driver.findElement(actionsPerformedTablePath);
    }
}
