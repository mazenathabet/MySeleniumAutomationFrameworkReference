package nopCommerceTraining.PageObjects;

import base.DriverActions;
import nopCommerceTraining.PageLocators.ShoppingCartPageLocators;

public class ShoppingCartPage {
    DriverActions driverActions = new DriverActions();


    public ShoppingCartPage selectTermsCheckbox(){
        driverActions.clickOn(ShoppingCartPageLocators.TERMS_CHECKBOX.by());
        return this;
    }
    public CheckoutPage goToCheckOut(){
        driverActions.scrollToElement(ShoppingCartPageLocators.CHECKOUT_BUTTON.by());
        driverActions.clickOn(ShoppingCartPageLocators.CHECKOUT_BUTTON.by());
        return new CheckoutPage();
    }
}
