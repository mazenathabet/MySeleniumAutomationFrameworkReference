package utilities;

import Config.Settings;
import base.DriverContext;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;

import static base.DriverContext.*;


public class Helper {
    /*
    Method to take screen shot when the test case fails
     and we make it public so we call it with helper.method instead of taking an object of the class
     */
    public static void captureScreenShotAtFailure(WebDriver driver, String ScreenShotName) {
        Path dest = Paths.get(Settings.ScreenShotsPath, ScreenShotName + ".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

    public static void takeScreenShotOfElement(By by) {
        File image = Driver.findElement(by).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(image, new File("src/ScreenShots/elementImage.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void takePageScreenshotAsFile() {
        File image = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
        try {
            Random random = new Random();
            Date date = new Date();
            FileUtils.copyFile(image, new File("src/ScreenShots/pageImage_" + random.nextInt()+date.getTime()+ ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
