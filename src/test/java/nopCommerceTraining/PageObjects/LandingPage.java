package nopCommerceTraining.PageObjects;

import base.DriverActions;
import nopCommerceTraining.PageLocators.LandingPageLocators;

import static nopCommerceTraining.PageLocators.LandingPageLocators.SUCCESSFUL_REGISTRATION_LABEL;

public class LandingPage{

    DriverActions driverActions = new DriverActions();

    public RegistrationPage goToRegistrationPage(){
        driverActions.clickOn(LandingPageLocators.REGISTER_LINK.by());
        return new RegistrationPage();
    }
    public boolean verifySuccessfulRegistration(){
        return driverActions.isElementDisplayed(SUCCESSFUL_REGISTRATION_LABEL.by());
    }
    public String getResultLabelText(){
       return driverActions.getElementText(SUCCESSFUL_REGISTRATION_LABEL.by());
    }
}
