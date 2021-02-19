package utilities;

import Config.Settings;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }
}
