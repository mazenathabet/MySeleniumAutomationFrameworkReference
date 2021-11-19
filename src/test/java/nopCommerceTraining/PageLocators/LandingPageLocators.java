package nopCommerceTraining.PageLocators;

import base.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public enum LandingPageLocators implements Locator {

    REGISTER_LINK(By.cssSelector(".ico-register")),
    SUCCESSFUL_REGISTRATION_LABEL(By.xpath("//div[@class='result']")),
    LOGIN_LINK(RelativeLocator.with(By.tagName("a")).toRightOf(REGISTER_LINK.by())),
    MY_ACCOUNT_LINK(By.cssSelector(".ico-account")),
    LOG_OUT_LINK(RelativeLocator.with(By.tagName("a")).toRightOf(MY_ACCOUNT_LINK.by())),
    PRODUCT_SEARCH_BAR(By.id("small-searchterms")),
    ORDER_CONFIRMED_LABEL(By.cssSelector("div[class='section order-completed'] div[class='title'] strong"))
    ;


    private By locator;




    LandingPageLocators(By locator) {
        this.locator = locator;
    }

    @Override
    public By by() {
        return locator;
    }



}
