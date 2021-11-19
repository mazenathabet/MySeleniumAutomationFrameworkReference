package nopCommerceTraining.PageLocators;

import base.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public enum CheckoutPageLocators implements Locator {

    COUNTRY_LIST(By.id("BillingNewAddress_CountryId")),
    CITY_FIELD(By.name("BillingNewAddress.City")),
    ADDRESS_1(By.name("BillingNewAddress.Address1")),
    ZIP_CODE(By.cssSelector("#BillingNewAddress_ZipPostalCode")),
    PHONE_NUMBER(By.cssSelector("#BillingNewAddress_PhoneNumber")),
    CONTINUE_TO_SHIPPING_ADDRESS(RelativeLocator.with(By.tagName("button")).below(PHONE_NUMBER.by())),
    CONTINUE_TO_PAYMENT_METHOD(By.cssSelector(".button-1.shipping-method-next-step-button")),
    CONTINUE_TO_PAYMENT_INFO(By.cssSelector("button[class='button-1 payment-method-next-step-button']")),
    CONTINUE_TO_CONFIRM_ORDER(By.cssSelector(".button-1.payment-info-next-step-button")),
    CONFIRM_ORDER(By.cssSelector(".button-1.confirm-order-next-step-button")),
    ;

    private By locator;


    CheckoutPageLocators(By locator) {
        this.locator = locator;
    }

    @Override
    public By by() {
        return locator;
    }



}
