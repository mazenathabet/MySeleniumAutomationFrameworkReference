package nopCommerceTraining.PageObjects;

import base.DriverActions;
import nopCommerceTraining.PageLocators.CheckoutPageLocators;

public class CheckoutPage {
    DriverActions driverActions = new DriverActions();

    public void fillCheckoutData(String country,String city, String address1, String zipCode, String phoneNum){
        driverActions.selectByVisibleText(CheckoutPageLocators.COUNTRY_LIST.by(),country);
        driverActions.sendKeysToElement(city,CheckoutPageLocators.CITY_FIELD.by());
        driverActions.sendKeysToElement(address1,CheckoutPageLocators.ADDRESS_1.by());
        driverActions.sendKeysToElement(zipCode,CheckoutPageLocators.ZIP_CODE.by());
        driverActions.sendKeysToElement(phoneNum,CheckoutPageLocators.PHONE_NUMBER.by());
        driverActions.clickOn(CheckoutPageLocators.CONTINUE_TO_SHIPPING_ADDRESS.by());
        driverActions.clickOn(CheckoutPageLocators.CONTINUE_TO_PAYMENT_METHOD.by());
        driverActions.clickOn(CheckoutPageLocators.CONTINUE_TO_PAYMENT_INFO.by());
        driverActions.clickOn(CheckoutPageLocators.CONTINUE_TO_CONFIRM_ORDER.by());
        driverActions.clickOn(CheckoutPageLocators.CONFIRM_ORDER.by());
    }
}
