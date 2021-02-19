package Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;

public class RegistrationWithFakeData extends FrameworkInitialize {

    By firstNameTxt = By.xpath("//input[@id='FirstName']");
    By lastNameTxt = By.xpath("//input[@id='LastName']");
    By emailTxt = By.xpath("//input[@id='Email']");
    By passwordTxt = By.xpath("//input[@id='Password']");
    By ConfirmPasswordTxt = By.xpath("//input[@id='ConfirmPassword']");
    By RegisterButton = By.xpath("//input[@id='register-button']");

    Faker fakerData = new Faker(new Locale("en"));
    String firstname = fakerData.name().firstName();
    String lastname = fakerData.name().lastName();
    String Email = fakerData.internet().emailAddress();
    String Password = fakerData.internet().password(8, 10, true, true, true);

    @BeforeMethod
    public void goToNopCommerceRegistrationPage() {
        DriverContext.Driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @Test
    public void RegisterUser() {
        RegisterUsingFakeData(firstname, lastname, Email, Password);
    }

    public void RegisterUsingFakeData(String firstname, String lastname, String Email, String Password) {
        DriverContext.Driver.findElement(firstNameTxt).sendKeys(firstname);
        DriverContext.Driver.findElement(lastNameTxt).sendKeys(lastname);
        DriverContext.Driver.findElement(emailTxt).sendKeys(Email);
        DriverContext.Driver.findElement(passwordTxt).sendKeys(Password);
        DriverContext.Driver.findElement(ConfirmPasswordTxt).sendKeys(Password);
        DriverContext.Driver.findElement(RegisterButton).click();
        System.out.println("Registered Data is : " + firstname + " /" + lastname + " /" + Email + " /" + Password);
    }
}
