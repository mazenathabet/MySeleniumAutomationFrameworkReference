package Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frames extends FrameworkInitialize {

    @BeforeMethod
    public void goToFramesPage() {
        DriverContext.Driver.get("https://cookbook.seleniumacademy.com/Frames.html");
    }
    /*
    Switch to different frames on the Page to apply the code on each frame if wanted
     */
    @Test(priority = 1)
    public void FramesTestUsingId() {
        DriverContext.Driver.switchTo().frame("left");
        By msg = By.tagName("p");
        System.out.println(DriverContext.Driver.findElement(msg).getText());
        //After finishing with
        DriverContext.Driver.switchTo().defaultContent();
    }
    @Test(priority = 2)
    public void FrameTestUsingName() {
        DriverContext.Driver.switchTo().frame("right");
        By msg = By.tagName("p");
        System.out.println(DriverContext.Driver.findElement(msg).getText());
        //After finishing with
        DriverContext.Driver.switchTo().defaultContent();
    }
    @Test(priority = 3)
    public void FrameTestUsingIndex() {
        DriverContext.Driver.switchTo().frame(1);
        By msg = By.tagName("p");
        System.out.println(DriverContext.Driver.findElement(msg).getText());
        //After finishing with
        DriverContext.Driver.switchTo().defaultContent();
    }
}
