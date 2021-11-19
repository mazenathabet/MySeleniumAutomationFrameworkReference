package SeleniumActions.Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class FindAllLinksByFindElements extends FrameworkInitialize {
    /*
    Finds all the Links of the selected page and prints out the link's attribute href value
    also verifies the size of the links
     */
    @Test
    @Severity(SeverityLevel.CRITICAL) //Allure annotation to set the severity of the test case to Critical
    @Description("Finding all links and printing them")// Allure annotation to set the Desc of the TestCase so it can be shown on allure report
    @Link(name = "trainingWebsite",url = "https://the-internet.herokuapp.com/")//Allure annotation to set the link of the Testcase to a name and url
    public void TestFindElements() {
        // Get All The Links Displayed On The Page
        List<WebElement> Links = DriverContext.Driver.findElements(By.tagName("a"));
        // Verify The Number Of The Links On The Page Equals 46
        Assert.assertEquals(Links.size(), 46, "The Number Of The Links Is Incorrect");
        // Print each link Value
        for (WebElement Link : Links) {
            System.out.println(Link.getAttribute("href"));
        }
        //Print The Number of The Links
        System.out.println("The Number of the links is  : " + Links.size());
    }
}
