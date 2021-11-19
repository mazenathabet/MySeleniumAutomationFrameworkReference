package nopCommerceTraining.DemoTests.Login;

import base.FrameworkInitialize;
import nopCommerceTraining.PageObjects.LandingPage;
import nopCommerceTraining.PageObjects.LoginPage;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class loginTests extends FrameworkInitialize {

    String email = "krystina.douglas@yahoo.com";
    String password = "";
    String NOT_REGISTERED_EMAIL = "invalid@test.com";
    String NOT_CORRECT_PASSWORD = "invalid password";
    String WRONG_FORMAT_EMAIL = "test_gmail.com";

    @Test
    void loginWithValidData(){
        LandingPage lPage = new LandingPage();
        lPage.goToLoginPage()
                .logInWithValidData(email,password)
                .verifySuccessfulLogin();
    }
    @Test
    void loginWithoutEnteringEmail(){
        LandingPage lPage = new LandingPage();
        lPage.goToLoginPage()
                .enterPassword(password)
                .checkRememberMeIfNotChecked()
                .clickLogIn();
        LoginPage loPage = new LoginPage();
        Assert.assertThat("",loPage.getEmailValidationMessage(),containsString("Please enter your email"));
        Assert.assertThat(loPage.getEmailValidationMessage(),equalTo("Please enter your email"));
    }
    @Test
    void loginWithoutEnteringPassword(){
        LandingPage lPage = new LandingPage();
        lPage.goToLoginPage()
                .enterEmail(email)
                .checkRememberMeIfNotChecked()
                .clickLogIn();
        LoginPage loPage = new LoginPage();
        Assert.assertThat("",loPage.getDataValidationMessage(),containsString("Please correct the errors and try again."));
        Assert.assertThat(loPage.getDataValidationMessage(),equalTo
                ("Login was unsuccessful. Please correct the errors and try again."+
                "The credentials provided are incorrect"));
    }
    @Test
    void loginWithInvalidData(){
        LandingPage lPage = new LandingPage();
        lPage.goToLoginPage()
                .enterEmail(NOT_REGISTERED_EMAIL)
                .enterPassword(NOT_CORRECT_PASSWORD)
                .checkRememberMeIfNotChecked()
                .clickLogIn();
        LoginPage loPage = new LoginPage();
        Assert.assertThat("",loPage.getDataValidationMessage(),containsString("Please correct the errors and try again."));
        Assert.assertThat(loPage.getDataValidationMessage(),equalTo
                ("Login was unsuccessful. Please correct the errors and try again.\n"+
                        "No customer account found"));
    }
    @Test
    void loginWrongFormaTEmail(){
        LandingPage lPage = new LandingPage();
        lPage.goToLoginPage()
                .enterEmail(WRONG_FORMAT_EMAIL)
                .enterPassword(password)
                .checkRememberMeIfNotChecked()
                .clickLogIn();
        LoginPage loPage = new LoginPage();
        Assert.assertThat("",loPage.getEmailValidationMessage(),containsString("Wrong email"));
        Assert.assertThat(loPage.getEmailValidationMessage(),equalTo("Wrong email"));
    }

}
