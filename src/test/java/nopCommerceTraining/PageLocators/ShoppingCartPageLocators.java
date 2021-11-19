package nopCommerceTraining.PageLocators;

import base.Locator;
import org.openqa.selenium.By;

public enum ShoppingCartPageLocators implements Locator {

    CHECKOUT_BUTTON(By.id("checkout")),
    TERMS_CHECKBOX(By.id("termsofservice")),
    ;


    private By locator;




    ShoppingCartPageLocators(By locator) {
        this.locator = locator;
    }

    @Override
    public By by() {
        return locator;
    }



}
