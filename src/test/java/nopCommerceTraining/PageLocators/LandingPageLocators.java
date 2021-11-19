package nopCommerceTraining.PageLocators;

import base.Locator;
import org.openqa.selenium.By;

public enum LandingPageLocators implements Locator {

    REGISTER_LINK(By.cssSelector(".ico-register")),
    SUCCESSFUL_REGISTRATION_LABEL(By.xpath("//div[@class='result']"))
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
