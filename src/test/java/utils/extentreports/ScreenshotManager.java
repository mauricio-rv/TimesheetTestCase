package utils.extentreports;

import org.apache.commons.io.FileUtils;
import org.example.utils.PropertyUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotManager {
    public static String ErrScPath = System.getProperty("user.dir")+"\\ErrorScreenshots\\";

    public static String takeScreenshot(WebDriver driver, String ssname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(ErrScPath + ssname +".png");
        FileUtils.copyFile(srcFile, destFile);
        return destFile.getPath();
    }
}
