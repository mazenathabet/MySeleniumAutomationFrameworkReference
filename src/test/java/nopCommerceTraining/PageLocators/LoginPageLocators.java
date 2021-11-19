package nopCommerceTraining.PageLocators;

import base.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public enum LoginPageLocators implements Locator {

    EMAIL_FIELD(By.id("Email")),
    PASSWORD_FIELD(By.id("Password")),
    REMEMBER_ME_CHECKBOX(By.id("RememberMe")),
    LOG_IN_BUTTON(RelativeLocator.with(By.tagName("button")).below(REMEMBER_ME_CHECKBOX.by())),
    EMAIL_IS_MANDATORY_LABEL(RelativeLocator.with(By.tagName("span")).below(EMAIL_FIELD.by())),
    PASSWORD_IS_MANDATORY_LABEL(By.xpath("//div[@class='message-error validation-summary-errors']")),
    ;


    private By locator;




    LoginPageLocators(By locator) {
        this.locator = locator;
    }

    @Override
    public By by() {
        return locator;
    }



}
