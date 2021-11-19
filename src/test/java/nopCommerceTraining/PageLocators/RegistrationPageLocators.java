package nopCommerceTraining.PageLocators;

import base.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public enum RegistrationPageLocators implements Locator {

    REGISTER_LABEL(By.xpath("//h1[normalize-space()='Register']")),
    MALE_GENDER_RADIO(By.cssSelector("#gender-male")),
    FEMALE_GENDER_RADIO(By.cssSelector("#gender-female")),
    FIRST_NAME_FIELD(By.id("FirstName")),
    LAST_NAME_FIELD(By.id("LastName")),
    BIRTH_DAY_LIST(By.name("DateOfBirthDay")),
    BIRTH_MONTH_LIST(By.name("DateOfBirthMonth")),
    BIRTH_YEAR_LIST(By.name("DateOfBirthYear")),
    EMAIL_FIELD(By.id("Email")),
    COMPANY_DETAILS_LABEL(By.xpath("//strong[normalize-space()='Company Details']")),
    COMPANY_FIELD(RelativeLocator.with(By.tagName("input")).below(COMPANY_DETAILS_LABEL.by())),
    PASSWORD_FIELD(By.id("Password")),
    CONFIRM_PASSWORD_FIELD(RelativeLocator.with(By.tagName("input")).below(PASSWORD_FIELD.by())),
    REGISTER_BUTTON(By.cssSelector("#register-button")),
    EXISTING_EMAIL_LABEL(By.xpath("//li[normalize-space()='The specified email already exists']")),
    ;


    private By locator;




    RegistrationPageLocators(By locator) {
        this.locator = locator;
    }

    @Override
    public By by() {
        return locator;
    }



}
