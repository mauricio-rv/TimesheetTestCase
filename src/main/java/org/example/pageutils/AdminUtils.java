package org.example.pageutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.example.pages.AdminPage;

import java.util.List;

public class AdminUtils extends AdminPage {
    public AdminUtils(WebDriver driver) {
        super(driver);
    }

    public boolean isAdminPageLoaded(){
        wait.until(d -> getAddButton().isDisplayed());
        return true;
    }

    public void clickAddButton(){
        getAddButton().click();
    }

    public boolean isUserInTable(String username) {
        wait.until(d -> getTable().isDisplayed());
        List<WebElement> users = getUsersInTable();
        for(WebElement user : users){
            if(user.getText().equals(username)){
                return true;
            }
        }
        return false;
    }
}
