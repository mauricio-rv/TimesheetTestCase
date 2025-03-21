package test;

import org.example.utils.PropertyUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentreports.ExtentTestManager.startTest;

public class TimeSheetFlowCase extends BaseTest{
    private final String username = PropertyUtils.getProperty("user.name");
    private final String employeeName = PropertyUtils.getProperty("user.employee.name");
    private final String password = PropertyUtils.getProperty("user.password");
    private final String adminUser = PropertyUtils.getProperty("admin.user");
    private final String adminPassword = PropertyUtils.getProperty("admin.password");
    private final String hoursWorked = PropertyUtils.getProperty("hours.worked");
    private final String hoursWorkedDaily = PropertyUtils.getProperty("hours.worked.daily");
    private final String comment = PropertyUtils.getProperty("comment.to.approve");

    @Test()
    public void loginTest(Method method) {
        startTest(method.getName(), "Login with admin credentials");
        loginUtils.isLoginPageLoaded();
        loginUtils.login(adminUser, adminPassword);
        Assert.assertTrue(dashboardUtils.isDashboardPageLoaded());
    }

    @Test(dependsOnMethods = "loginTest")
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

    @Test(dependsOnMethods = "addEmployeeTest")
    public void logoutAndLoginWithNewUser(Method method) {
        startTest(method.getName(), "Logout and login with new user credentials");
        dashboardUtils.logout();
        loginUtils.isLoginPageLoaded();
        loginUtils.login(username, password);
        Assert.assertTrue(dashboardUtils.isDashboardPageLoaded());
    }

    @Test(dependsOnMethods = "logoutAndLoginWithNewUser")
    public void addTimeSheetTest(Method method) {
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

    @Test(dependsOnMethods = "addTimeSheetTest")
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

    @Test(dependsOnMethods = "approveTimesheetTest")
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
