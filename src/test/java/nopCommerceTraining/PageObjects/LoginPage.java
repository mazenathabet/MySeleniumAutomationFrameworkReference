package nopCommerceTraining.PageObjects;

import base.DriverActions;
import nopCommerceTraining.PageLocators.LandingPageLocators;
import nopCommerceTraining.PageLocators.LoginPageLocators;

public class LoginPage {
    DriverActions driverActions = new DriverActions();

    public LoginPage enterEmail(String email){
        driverActions.sendKeysToElement(email,LoginPageLocators.EMAIL_FIELD.by());
        return this;
    }
    public LoginPage enterPassword(String password){
        driverActions.sendKeysToElement(password,LoginPageLocators.PASSWORD_FIELD.by());
        return this;
    }
    public LoginPage checkRememberMeIfNotChecked(){
        if(!driverActions.isSelected(LoginPageLocators.REMEMBER_ME_CHECKBOX.by())){
            driverActions.clickOn(LoginPageLocators.REMEMBER_ME_CHECKBOX.by());
        }else{
            System.out.println("remember me checkbox is already checked");
        }
        return this;
    }
    public LoginPage clickLogIn(){
        driverActions.clickOn(LoginPageLocators.LOG_IN_BUTTON.by());
        return this;
    }
    public LandingPage logInWithValidData(String email , String password){
        enterEmail(email);
        enterPassword(password);
        checkRememberMeIfNotChecked();
        clickLogIn();
        return new LandingPage();
    }
    public String getEmailValidationMessage(){
       return driverActions.getElementText(LoginPageLocators.EMAIL_IS_MANDATORY_LABEL.by());
    }
    public String getDataValidationMessage(){
        return driverActions.getElementText(LoginPageLocators.PASSWORD_IS_MANDATORY_LABEL.by());
    }

}
