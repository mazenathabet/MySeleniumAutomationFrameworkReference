package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterSteps {


    WebDriver driver;
    WebDriverWait wait;



    @Given("User at the homepage")
    public void user_at_the_homepage() {

        driver.get("https://demo.nopcommerce.com/");
//      driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    }

    @When("User clicks on Register Link")
    public void user_clicks_on_register_link() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
//      driver.findElement(By.linkText("Register"));
    }

    @When("user clicks on login link")
    public void user_clicks_on_login_link() {
        wait = new WebDriverWait(driver, 10);
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
    }

    @Then("User should be logged in successfully and logout")
    public void user_should_be_logged_in_successfully_and_logout() {
        wait = new WebDriverWait(driver,10);
//        WebElement logoutButton  = driver.findElement(By.xpath("//a[@class='ico-logout']"));
//        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
//        logoutButton.click();
    }

    @And("User fills the registration form {string} {string} {string} {string} and clicks submit")
    public void user_Fills_TheRegistration_Form_And_Clicks_Submit(String fName, String lName, String email, String password) {
        wait = new WebDriverWait(driver,10);
        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='FirstName']"));
        wait.until(ExpectedConditions.visibilityOf(firstNameTxtBox));
        firstNameTxtBox.sendKeys(fName);
        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@id='LastName']"));
        wait.until(ExpectedConditions.visibilityOf(lastNameTxtBox));
        lastNameTxtBox.sendKeys(lName);
        WebElement emailTxtBox = driver.findElement(By.xpath("//input[@id='Email']"));
        wait.until(ExpectedConditions.visibilityOf(emailTxtBox));
        emailTxtBox.sendKeys(email);
        WebElement passwordTxtBox = driver.findElement(By.xpath("//input[@id='Password']"));
        wait.until(ExpectedConditions.visibilityOf(passwordTxtBox));
        passwordTxtBox.sendKeys(password);
        WebElement confirmPasswordTxtBox = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordTxtBox));
        confirmPasswordTxtBox.sendKeys(password);
        WebElement SubmitBtn = driver.findElement(By.xpath("//button[@id='register-button']"));
        wait.until(ExpectedConditions.elementToBeClickable(SubmitBtn));
        SubmitBtn.click();
//        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("test1");
//        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("test");
//        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Email@gmail.com");
//        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("password");
//        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("password");
//        driver.findElement(By.xpath("//button[@id='register-button']")).click();

    }

    @Then("User should be registered successfully")
    public void user_should_be_registered_successfully() {
//        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).isDisplayed());
        WebElement RegisteredLabel = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertTrue(RegisteredLabel.isDisplayed());
        WebElement logoutButton  = driver.findElement(By.xpath("//a[@class='ico-logout']"));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    @And("user login with valid data {string} and {string}")
    public void user_Login_With_Valid_Data_email_And_password(String email, String password) throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        Thread.sleep(2000);
        WebElement emailTxtBox = driver.findElement(By.id("Email"));
        wait.until(ExpectedConditions.visibilityOf(emailTxtBox));
        emailTxtBox.sendKeys(email);
        WebElement passwordTxtBox = driver.findElement(By.id("Password"));
        wait.until(ExpectedConditions.visibilityOf(passwordTxtBox));
        passwordTxtBox.sendKeys(password);
        driver.findElement(By.id("RememberMe")).click();
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit'][@class='button-1 login-button']"));
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
    }
}
