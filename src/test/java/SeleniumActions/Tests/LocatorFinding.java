package SeleniumActions.Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorFinding extends FrameworkInitialize {
    @Test
    public void ElementLocating() {
        /**
         absolute xpath: not recommended
         *[@id='headerSearchbar']/div/div[2]/table/tBody/tr/td[2]/input
         1. performance issue
         2. not reliable
         3. can be changed at any time in future
         */
        DriverContext.Driver.findElement(By.xpath("//input[@class='acTextBox']")).sendKeys("Java");

        DriverContext.Driver.findElement(By.xpath("//input[@name='query']")).sendKeys("Java");

        DriverContext.Driver.findElement(By.xpath("//input[contains(@class,'acTextBox')]")).sendKeys("Java");
        /**
         dynamic id: input
         id = test_123
         By.id("test_123")

         starts-with
         id = test_456
         id = test_789
         id = test_test_7890_test

         ends-with
         id = 1234_test_t
         id = 23456_test_t
         id = 6789_test_t
         */
        DriverContext.Driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("Test");
        DriverContext.Driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Test");
        DriverContext.Driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendKeys("Test");
        /**
         for links: custom xpath:
         all the links are represented by <a> html tag:
         */
         DriverContext.Driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

         /**
         1. xpath: -- 2
         absolute xpath should not be used. -- html/body/div[1]/div[5]/div[2]/a
         only relative xpath should be used. -- //*[@id='firstname']
         */

        DriverContext.Driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Tom");

        DriverContext.Driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("Peter");

        DriverContext.Driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("12, new street");


        /**2. id: -- */
        DriverContext.Driver.findElement(By.id("firstname")).sendKeys("Tom");
        DriverContext.Driver.findElement(By.id("lastname")).sendKeys("Peter");

        /**3. name: --3 */
        DriverContext.Driver.findElement(By.name("firstname")).sendKeys("Tom");
        DriverContext.Driver.findElement(By.name("lastname")).sendKeys("Peter");


        /**4. linkText : this is only for links*/
        DriverContext.Driver.findElement(By.linkText("Sign in")).click();

        /**5. partialLinkText: not useful */
        DriverContext.Driver.findElement(By.partialLinkText("How to pick")).click();


        /**6. CSSSelector: ---2
         if id is there--- #{id}
         if class is there --- .{class}
         */
        DriverContext.Driver.findElement(By.cssSelector("#address1")).sendKeys("12 new start");

        /** 7. class name: not useful  --4*/
        DriverContext.Driver.findElement(By.className("ancAsb")).click();

    }

}

