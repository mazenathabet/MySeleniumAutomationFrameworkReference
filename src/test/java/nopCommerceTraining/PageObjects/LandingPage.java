package nopCommerceTraining.PageObjects;

import base.DriverActions;
import nopCommerceTraining.PageLocators.LandingPageLocators;
import org.openqa.selenium.Keys;

import static nopCommerceTraining.PageLocators.LandingPageLocators.SUCCESSFUL_REGISTRATION_LABEL;

public class LandingPage{

    DriverActions driverActions = new DriverActions();

    public RegistrationPage goToRegistrationPage(){
        driverActions.clickOn(LandingPageLocators.REGISTER_LINK.by());
        return new RegistrationPage();
    }
    public LoginPage goToLoginPage(){
        driverActions.clickOn(LandingPageLocators.LOGIN_LINK.by());
        return new LoginPage();
    }

    public boolean verifySuccessfulRegistration(){
        return driverActions.isElementDisplayed(SUCCESSFUL_REGISTRATION_LABEL.by());
    }
    public String getResultLabelText(){
       return driverActions.getElementText(SUCCESSFUL_REGISTRATION_LABEL.by());
    }
    public boolean verifySuccessfulLogin(){
        return driverActions.isElementDisplayed(LandingPageLocators.MY_ACCOUNT_LINK.by());
    }

    public SearchPage searchForProduct(String product){
        driverActions.sendKeyChords(product, Keys.ENTER,LandingPageLocators.PRODUCT_SEARCH_BAR.by());
        return new SearchPage();
    }
    public boolean checkOrderIsConfirmed(){
        return driverActions.isElementDisplayed(LandingPageLocators.ORDER_CONFIRMED_LABEL.by());
    }
    public String getOrderLabelText(){
        return driverActions.getElementText(LandingPageLocators.ORDER_CONFIRMED_LABEL.by());
    }
}
