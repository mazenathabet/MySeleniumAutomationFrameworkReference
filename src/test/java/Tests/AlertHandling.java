package Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertHandling extends FrameworkInitialize {

    By ConfirmBox = By.xpath("//button[@id='confirm']");
    By AlertBox = By.xpath("//input[@id='simple']");
    By promptBox = By.xpath("//button[@id='prompt']");
    /*
    Alerts Library is so important when dealing with different types of alerts such as
    - Simple alert
    - Prompt alert to enter a text on
    - Confirm/cancel alert
     */
    @BeforeMethod
    public void goToAlertPage() {
        //this website only works on Firefox so change the Browser variable at Settings class to " firefox "
        DriverContext.Driver.get("https://cookbook.seleniumacademy.com/Alerts.html");
    }
    @Test(priority = 1)
    public void HandleAlerts() {
        //Click on Alert Box
        DriverContext.Driver.findElement(AlertBox).click();
        //Get the Alert
        Alert alert = DriverContext.Driver.switchTo().alert();
        //Get the Text on the Alert Box
        String textOnAlert = alert.getText();
        //Click ok and accept the alert
        alert.accept();
    }
    @Test(priority = 2)
    public void acceptConfirmAlert() {
        //Click on ConfirmBox alert again
        DriverContext.Driver.findElement(ConfirmBox).click();
        //Get the Confirm Alert
        Alert ConfirmBoxAlert = DriverContext.Driver.switchTo().alert();
        //Click on Ok
        ConfirmBoxAlert.accept();
    }
    @Test(priority = 3)
    public void CancelConfirmAlert() {
        //Click on ConfirmBox alert
        DriverContext.Driver.findElement(ConfirmBox).click();
        //Get the Confirm Alert
        Alert ConfirmBoxAlert = DriverContext.Driver.switchTo().alert();
        //Click on cancel
        ConfirmBoxAlert.dismiss();
    }
    @Test(priority = 4)
    public void sendKeysToPromptAlert() {
        //Click on prompt alert
        DriverContext.Driver.findElement(promptBox).click();
        //Get the prompt alert
        Alert promptAlert = DriverContext.Driver.switchTo().alert();
        //send keys to the alert
        promptAlert.sendKeys(" I just wanted you to know that Mazen Rocks !! ");
        //Confirm the alert
        promptAlert.accept();
    }
}
