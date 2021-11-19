package nopCommerceTraining.DemoTests.E2E_Scenarios;

import Config.UserData;
import base.FrameworkInitialize;
import com.github.javafaker.Faker;
import nopCommerceTraining.PageObjects.LandingPage;
import nopCommerceTraining.PageObjects.ProductPage;
import nopCommerceTraining.PageObjects.RegistrationPage;
import nopCommerceTraining.PageObjects.SearchPage;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PlaceOrder extends FrameworkInitialize {

    Faker faker = new Faker();
    String fName = faker.name().firstName();
    String lName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String company = faker.company().name();
    String password = faker.internet().password(
            8
            ,10
            ,true
            ,true
            , true);
    String country = faker.country().name();
    String city = faker.country().capital();
    String address1 = faker.address().streetAddress();
    String postalCode = faker.address().zipCode();
    String phoneNum = faker.phoneNumber().phoneNumber();


    @Test(priority = 1)
    void UserCanRegisterNewAccount() {
        LandingPage lPage = new LandingPage();
        lPage.goToRegistrationPage().checkRegistrationPageIsOpened();
        RegistrationPage rPage = new RegistrationPage();
        assertTrue(rPage.checkRegistrationPageIsOpened());
        rPage.selectGender(UserData.gender)
                .enterFirstName(fName)
                .enterLastName(lName)
                .enterBirthData(
                        UserData.Birth_day,
                        UserData.Birth_month,
                        UserData.Birth_year)
                .enterEmail(email)
                .enterCompanyName(company)
                .enterPasswordAndConfirmIt(password)
                .clickRegisterButton();
        System.out.println(email);
        System.out.println(password);
        assertTrue("registration is not completed", lPage.verifySuccessfulRegistration());
        assertThat("",lPage.getResultLabelText(),containsString("Your registration completed"));
    }
    @Test(dependsOnMethods = "UserCanRegisterNewAccount")
    void addProductToCard(){
        LandingPage lPage = new LandingPage();
        lPage.goToLoginPage()
                .logInWithValidData(email,password)
                .searchForProduct(UserData.product);
        SearchPage sPage = new SearchPage();
        Assert.assertTrue(sPage.checkProductNameAndImageAreCorrect((UserData.product)));
        sPage.goToProductPage().setProductQuantity(UserData.PRODUCT_QTY);
        ProductPage pPage = new ProductPage();
        Assert.assertTrue(pPage.verifyProductIsCorrect((UserData.product)));
        pPage.addToCart()
                .goToShoppingCart()
                .selectTermsCheckbox()
                .goToCheckOut()
                .fillCheckoutData(
                country
                ,city
                ,address1
                ,postalCode
                ,phoneNum);
        Assert.assertTrue("order is not confirmed",lPage.checkOrderIsConfirmed());
        Assert.assertThat("",lPage.getOrderLabelText(),containsString("Your order has been successfully processed!"));
        Assert.assertThat("",lPage.getOrderLabelText(),equalTo("Your order has been successfully processed!"));
    }
}
