package org.example.pageutils;

import org.openqa.selenium.WebDriver;
import org.example.pages.AddUserPage;

public class AddUserUtils extends AddUserPage {
    public AddUserUtils(WebDriver driver) {
        super(driver);
    }

    public boolean isAddUserPageLoaded(){
        wait.until(d -> getSaveButton().isDisplayed());
        return true;
    }

    public void addUser(String employeeName, String username, String password) {
        try{
            getSelectRoleAndStatus().get(0).click();
            wait.until(d -> getListbox().get(2).isDisplayed());
            getListbox().get(2).click();

            getEmployeeInput().sendKeys(employeeName);
            wait.until(d -> getListbox().get(0).getText().equals(employeeName));
            getListbox().get(0).click();

            getSelectRoleAndStatus().get(1).click();
            wait.until(d -> getListbox().get(1).isDisplayed());
            getListbox().get(1).click();

            getUsernameInput().sendKeys(username);
            getPasswordAndConfirmPassword().get(0).sendKeys(password);
            getPasswordAndConfirmPassword().get(1).sendKeys(password);

            getSaveButton().click();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
