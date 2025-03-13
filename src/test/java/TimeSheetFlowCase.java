import org.testng.Assert;
import org.testng.annotations.Test;
import org.timesheet.pages.LoginPage;

public class TimeSheetFlowCase extends BaseTest{
    private final String username = "chipa3";
    private final String employeeName = "James Butler";
    private final String password = "grandechipa1";
    private final String adminUser = "Admin";
    private final String adminPassword = "admin123";
    private final String hoursWorked = "40:00";
    private final String hoursWorkedDaily = "8";
    private final String comment = "Approved";

    @Test(priority = 0)
    public void loginTest() {
        loginUtils.isLoginPageLoaded();
        loginUtils.login(adminUser, adminPassword);
        Assert.assertTrue(dashboardUtils.isDashboardPageLoaded());
    }

    @Test(priority = 1)
    public void addEmployeeTest()  {
        dashboardUtils.goToAdminPage();
        adminUtils.isAdminPageLoaded();
        adminUtils.clickAddButton();
        addUserUtils.isAddUserPageLoaded();
        addUserUtils.addUser(employeeName, username, password);
        adminUtils.isAdminPageLoaded();
        Assert.assertTrue(adminUtils.isUserInTable(username));
    }

    @Test(priority = 2)
    public void logoutAndLoginWithNewUser() {
        dashboardUtils.logout();
        loginUtils.isLoginPageLoaded();
        loginUtils.login(username, password);
        Assert.assertTrue(dashboardUtils.isDashboardPageLoaded());
    }

    @Test(priority = 3)
    public void addTimeSheetTest() throws InterruptedException {
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
    public void editTimeSheetTest() {
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
    public void validateApproveAndComment(){
        loginUtils.login(username, password);
        dashboardUtils.isDashboardPageLoaded();
        dashboardUtils.goToTimePage();
        timeSheetUtils.isTimeSheetPageDisplayed();
        timeSheetUtils.isTotalHoursCorrect(hoursWorked);
        Assert.assertTrue(timeSheetUtils.validateCommentAndApproved(comment));
    }
}
