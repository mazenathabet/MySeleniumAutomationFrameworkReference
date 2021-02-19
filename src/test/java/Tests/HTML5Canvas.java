package Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class HTML5Canvas extends FrameworkInitialize {
    @BeforeMethod
    public void goToHTML5Canvas() {
        DriverContext.Driver.get("https://cookbook.seleniumacademy.com/html5canvasdraw.html");
    }

    @Test
    public void TestHTMLCanvas() throws IOException {
        WebElement drawList = DriverContext.Driver.findElement(By.id("dtool"));
        WebElement canvas = DriverContext.Driver.findElement(By.id("imageTemp"));
        Select drawTool = new Select(drawList);
        drawTool.selectByValue("pencil");
        Actions builder = new Actions(DriverContext.Driver);
        builder.clickAndHold(canvas).moveByOffset(10, 150).moveByOffset(150, 10)
                .moveByOffset(-10, -150).moveByOffset(-150, -10).release().perform();
        // Takes ScreenShot
        File srcFile = ((TakesScreenshot) DriverContext.Driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("\\src\\ScreenShots\\canvas.png"));
    }
}
