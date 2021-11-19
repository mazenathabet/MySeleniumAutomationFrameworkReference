package SeleniumActions.Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClassOnElements extends FrameworkInitialize {

    By message = By.xpath("//*[@id='message']");
    By ListedElement = By.xpath("whatever");
    /*
    Actions library is so important when we need to perform a mouse and keyboard keys such as double click , context menu
    Hover on specific element, drag and drop or click and hold specific key
     */
    @Test
    public void ActionClass() {
        //Initiate the Actions Class
        Actions builder = new Actions(DriverContext.Driver);
        //Perform Double Click on WebElement
        builder.doubleClick((WebElement) message).perform();
        //Perform mouse hover on an element
        builder.moveToElement((WebElement) message).perform();
        //Perform Context Click on an element then clicks on specific element at that list
        builder.contextClick((WebElement) message)
                .moveToElement((WebElement) ListedElement)
                .click()
                .build()
                .perform();
        //Perform Drag and Drop from source element to target element
        builder.dragAndDrop((WebElement) message, (WebElement) message);
        //Perform Drag and hold on an element
        builder.clickAndHold(DriverContext.Driver.findElement(By.xpath("//*[@id='draggable']")))
                .moveToElement(DriverContext.Driver.findElement(By.xpath("//*[@id='droppable']")))
                .release()
                .build()
                .perform();
        //Perform SendKeys to an element
        builder.sendKeys((WebElement) message, "value");
        //Perform Click on an element
        builder.click((WebElement) message);
        //Perform Key actions
        builder.keyDown((WebElement) message, "");
        builder.keyUp((WebElement) message, "");
    }
}
