package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
    public static WebDriverWait wait;
    public WebDriver driver;
    /*
    a constructor to use the driver and the wait variable on the child class
     */
    public PageBase() {
        this.driver = DriverContext.Driver;
        wait = new WebDriverWait(DriverContext.Driver, 10);
    }
    /*
    This method takes the retrieved elements and waits for it until the element is
    visible and locates it
     */
    public WebElement locateElement(By locator) {
        wait.until(ExpectedConditions.visibilityOf(retrieveElement(locator)));
        return driver.findElement(locator);
    }
    /*
    This Method makes the driver waits for specific period of time until the Element is present on the DOM
    then it retrieves the element and locate it
     */
    public WebElement retrieveElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
