package utils.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.example.utils.PropertyUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.BaseTest;
import utils.extentreports.ExtentManager;
import utils.extentreports.ScreenshotManager;

import java.io.File;
import java.io.IOException;

import static utils.extentreports.ExtentTestManager.getTest;

public class TestListener extends BaseTest implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Override
    public void onStart(ITestContext iTestContext) {
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        //Do tier down operations for ExtentReports reporting!
        ExtentManager.extentReports.flush();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //ExtentReports log operation for passed tests.
        String screenshotPath = null;
        try {
            screenshotPath = ScreenshotManager.takeScreenshot(driver, getTestMethodName(iTestResult));
            //ExtentReports log and screenshot operations for passed tests.
            getTest().pass( "Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //Take base64Screenshot screenshot for extent reports
        try {
            String screenshotPath = ScreenshotManager.takeScreenshot(driver, getTestMethodName(iTestResult));
            //ExtentReports log and screenshot operations for failed tests.
            getTest().fail( "Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        //ExtentReports log operation for skipped tests.
        getTest().log(Status.SKIP, "Test Skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

}
