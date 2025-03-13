package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentreports.ExtentTestManager.startTest;

public class TimeSheetFlowCase extends BaseTest{
    private final String username = "chipa";
    private final String employeeName = "Timothy Lewis Amiano";
    private final String password = "grandechipa1";
    private final String adminUser = "Admin";
    private final String adminPassword = "admin123";
    private final String hoursWorked = "40:00";
    private final String hoursWorkedDaily = "8";
    private final String comment = "Approved";

    @Test(priority = 0)
    public void loginTest(Method method) {
        startTest(method.getName(), "Login with admin credentials");
        loginUtils.isLoginPageLoaded();
        loginUtils.login(adminUser, adminPassword);
        Assert.assertTrue(dashboardUtils.isDashboardPageLoaded());
    }

    @Test(priority = 1)
    public void addEmployeeTest(Method method)  {
        startTest(method.getName(), "Add a new employee");
        dashboardUtils.goToAdminPage();
        adminUtils.isAdminPageLoaded();
        adminUtils.clickAddButton();
        addUserUtils.isAddUserPageLoaded();
        addUserUtils.addUser(employeeName, username, password);
        adminUtils.isAdminPageLoaded();
        Assert.assertTrue(adminUtils.isUserInTable(username));
    }

    @Test(priority = 2)
    public void logoutAndLoginWithNewUser(Method method) {
        startTest(method.getName(), "Logout and login with new user credentials");
        dashboardUtils.logout();
        loginUtils.isLoginPageLoaded();
        loginUtils.login(username, password);
        Assert.assertTrue(dashboardUtils.isDashboardPageLoaded());
    }

    @Test(priority = 3)
    public void addTimeSheetTest(Method method) throws InterruptedException {
        startTest(method.getName(), "Add a new timesheet with the new user");
        dashboardUtils.goToTimePage();
        timeSheetUtils.isTimeSheetPageDisplayed();
        timeSheetUtils.clickEditButton();
        editTimeSheetUtils.fillTimeSheetData("ACME", hoursWorkedDaily);
        timeSheetUtils.isTimeSheetPageDisplayed();
        timeSheetUtils.isTotalHoursCorrect(hoursWorked);
        timeSheetUtils.submitAndWaitForActions();
        dashboardUtils.logout();
        Assert.assertTrue(loginUtils.isLoginPageLoaded());
    }

    @Test(priority = 4)
    public void approveTimesheetTest(Method method) {
        startTest(method.getName(), "Approve the new user timesheet with the admin user");
        loginUtils.login(adminUser, adminPassword);
        dashboardUtils.isDashboardPageLoaded();
        dashboardUtils.goToTimePage();
        timeSheetUtils.isAdminTimeSheetPageDisplayed();
        timeSheetUtils.searchEmployeeTimeSheet(employeeName);
        timeSheetUtils.addCommentAndApprove(comment);
        dashboardUtils.logout();
        Assert.assertTrue(loginUtils.isLoginPageLoaded());
    }

    @Test(priority = 5)
    public void validateApproveAndComment(Method method){
        startTest(method.getName(), "Validate if its approved with the new user");
        loginUtils.login(username, password);
        dashboardUtils.isDashboardPageLoaded();
        dashboardUtils.goToTimePage();
        timeSheetUtils.isTimeSheetPageDisplayed();
        timeSheetUtils.isTotalHoursCorrect(hoursWorked);
        Assert.assertTrue(timeSheetUtils.validateCommentAndApproved(comment));
    }
}
