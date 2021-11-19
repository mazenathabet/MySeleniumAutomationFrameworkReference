package nopCommerceTraining.DemoTests.Registration;

import base.FrameworkInitialize;
import com.github.javafaker.Faker;
import nopCommerceTraining.PageObjects.LandingPage;
import nopCommerceTraining.PageObjects.RegistrationPage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class RegistrationTest extends FrameworkInitialize {

    Faker faker = new Faker();
    String gender = "male";
    String fName = faker.name().firstName();
    String lName = faker.name().lastName();
    String day = "18";
    String month = "December";
    String year = "1992";
    String email = faker.internet().emailAddress();
    String email2 = faker.internet().emailAddress();
    String company = faker.company().name();
    String password = faker.internet().password(
            8
            ,10
            ,true
            ,true
            , true);
    String successMessage = "Your registration completed";
    String ExistingEmailMessage = "The specified email already exists";

    @Test()
    void UserCanRegisterNewAccount() {
        LandingPage lPage = new LandingPage();
        lPage.goToRegistrationPage().checkRegistrationPageIsOpened();
        RegistrationPage rPage = new RegistrationPage();
        assertTrue(rPage.checkRegistrationPageIsOpened());
        rPage.selectGender(gender)
                .enterFirstName(fName)
                .enterLastName(lName)
                .enterBirthData(
                        day,
                        month,
                        year)
                .enterEmail(email)
                .enterCompanyName(company)
                .enterPasswordAndConfirmIt(password)
                .clickRegisterButton();
        System.out.println(email);
        System.out.println(password);
        assertTrue("registration is not completed", lPage.verifySuccessfulRegistration());
        assertThat("",lPage.getResultLabelText(),containsString(successMessage));
    }

    @Test (dependsOnMethods = "UserCanRegisterNewAccount")
    void UserCantRegisterWithExistingEmail() {
        LandingPage lPage = new LandingPage();
        lPage.goToRegistrationPage().checkRegistrationPageIsOpened();
        RegistrationPage rPage = new RegistrationPage();
        rPage.selectGender(gender)
                .enterFirstName(fName)
                .enterLastName(lName)
                .enterBirthData(
                        day,
                        month,
                        year)
                .enterEmail(email)
                .enterCompanyName(company)
                .enterPasswordAndConfirmIt(password)
                .clickRegisterButton();
        assertTrue(rPage.getExistingEmailLabelText().contains("email already exists"));
        assertEquals(rPage.getExistingEmailLabelText(),ExistingEmailMessage);
        assertThat(rPage.getExistingEmailLabelText(),containsString("email already exists"));
        assertThat(rPage.getExistingEmailLabelText(),equalTo(ExistingEmailMessage));
    }

    @Test
    void UserCanRegisterWithMandatoryDataOnly() {
        LandingPage lPage = new LandingPage();
        lPage.goToRegistrationPage().checkRegistrationPageIsOpened();
        RegistrationPage rPage = new RegistrationPage();
           rPage.enterFirstName(fName)
                .enterLastName(lName)
                .enterEmail(email2)
                .enterPasswordAndConfirmIt(password)
                .clickRegisterButton();
        assertTrue("registration is not completed", lPage.verifySuccessfulRegistration());
        assertThat("",lPage.getResultLabelText(),containsString(successMessage));
    }
}
