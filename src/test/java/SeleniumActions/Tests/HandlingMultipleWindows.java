package SeleniumActions.Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingMultipleWindows extends FrameworkInitialize {
    /*
    Window Handling Method to handle all the opened Tabs or windows and applies code on each window if needed
     */
    By VisitUsLink = By.xpath("//button[@id='visitbutton']");
    By HelpLink = By.id("helpbutton");

    @BeforeMethod
    public void goToMultipleWindowsPage() {
        //works on Firefox only
        DriverContext.Driver.get("https://cookbook.seleniumacademy.com/Config.html");
    }

    @Test(priority = 1)
    public void handleMultipleWindowsUsingTitle() {
        // Store WindowHandle of Parent browser Window
        String ParentWindowId = DriverContext.Driver.getWindowHandle();
        // Click on the opening new tab button
        DriverContext.Driver.findElement(VisitUsLink).click();
        // Get Handles of all the open windows
        //Iterate the list and check if title of each window as expected title
        try {
            for (String windowId : DriverContext.Driver.getWindowHandles()) {
                String title = DriverContext.Driver.switchTo().window(windowId).getTitle();
                if (title.equals("Visit Us")) {
                    Assert.assertEquals("Visit Us", DriverContext.Driver.getTitle(), "Page Title is incorrect");
                    //Write any code to handle elements in Visit us page
                    System.out.println(DriverContext.Driver.getTitle());
                    //Close Visit us Page
                    DriverContext.Driver.close();
                    break;
                }
            }
        } finally {
            //Switch to the Parent browser window
            DriverContext.Driver.switchTo().window(ParentWindowId);
        }
    }

    @Test(priority = 2)
    public void HandleMultipleWindowsUsingName() {
        //Store WindowHandle of parent window
        String currentWindowId = DriverContext.Driver.getWindowHandle();
        DriverContext.Driver.findElement(HelpLink).click();
        DriverContext.Driver.switchTo().window("HelpWindow");
        Assert.assertEquals("Help", DriverContext.Driver.getTitle(), "Page Title is incorrect");
        System.out.println(DriverContext.Driver.getTitle());
        // code inside Help Window
        DriverContext.Driver.close();
        DriverContext.Driver.switchTo().window(currentWindowId);

    }
}
