package CucumberDemo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterSteps {


    WebDriver driver;
    WebDriverWait wait;

    @Given("User open website and go to homepage")
    public void user_open_website_and_go_to_homepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
//      driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    }

    @When("User clicks on Register Link")
    public void user_clicks_on_register_link() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
//      driver.findElement(By.linkText("Register"));
    }

//    @When("User fills the registration form and clicks submit")
//    public void user_fills_the_registration_form_and_clicks_submit() {
//
//    }

    @When("User fills the registration form and clicks submit")
    public void user_fills_the_registration_form_and_clicks_submit() {
//        wait = new WebDriverWait(driver,10);
//        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='FirstName']"));
//        wait.until(ExpectedConditions.visibilityOf(firstNameTxtBox));
//        firstNameTxtBox.sendKeys("mazen");
//        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@id='LastName']"));
//        wait.until(ExpectedConditions.visibilityOf(lastNameTxtBox));
//        firstNameTxtBox.sendKeys("Ahmed");
//        WebElement emailTxtBox = driver.findElement(By.xpath("//input[@id='Email']"));
//        wait.until(ExpectedConditions.visibilityOf(emailTxtBox));
//        firstNameTxtBox.sendKeys("Email@gmail.com");
//        WebElement passwordTxtBox = driver.findElement(By.xpath("//input[@id='Password']"));
//        wait.until(ExpectedConditions.visibilityOf(passwordTxtBox));
//        firstNameTxtBox.sendKeys("password");
//        WebElement confirmPasswordTxtBox = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
//        wait.until(ExpectedConditions.visibilityOf(confirmPasswordTxtBox));
//        firstNameTxtBox.sendKeys("password");
//        WebElement SubmitBtn = driver.findElement(By.xpath("//button[@id='register-button']"));
//        wait.until(ExpectedConditions.elementToBeClickable(SubmitBtn));
//        SubmitBtn.click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("mazen");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Ahmed");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("emailTxtBox");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
    }

    @Then("User should be registered successfully")
    public void user_should_be_registered_successfully() {
//        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).isDisplayed());
    }

}
