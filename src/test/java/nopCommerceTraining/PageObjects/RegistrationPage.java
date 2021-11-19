package nopCommerceTraining.PageObjects;

import base.DriverActions;

import static nopCommerceTraining.PageLocators.RegistrationPageLocators.*;

public class RegistrationPage{

    DriverActions driverActions = new DriverActions();

    public boolean checkRegistrationPageIsOpened() {
        return driverActions.isElementDisplayed(REGISTER_LABEL.by());
    }

    public RegistrationPage selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driverActions.clickOn(MALE_GENDER_RADIO.by());
        } else {
            driverActions.clickOn(FEMALE_GENDER_RADIO.by());
        }
        return this;
    }

    public RegistrationPage enterFirstName(String fName) {
        driverActions.sendKeysToElement(fName, FIRST_NAME_FIELD.by());
        return this;
    }

    public RegistrationPage enterLastName(String lName) {
        driverActions.sendKeysToElement(lName, LAST_NAME_FIELD.by());
        return this;
    }

    public RegistrationPage enterBirthData(String day, String month, String year) {
        driverActions.selectByVisibleText(BIRTH_DAY_LIST.by(), day);
        driverActions.selectByVisibleText(BIRTH_MONTH_LIST.by(), month);
        driverActions.selectByVisibleText(BIRTH_YEAR_LIST.by(), year);
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        driverActions.sendKeysToElement(email, EMAIL_FIELD.by());
        return this;
    }

    public RegistrationPage enterCompanyName(String company) {
        driverActions.sendKeysToElement(company, COMPANY_FIELD.by());
        return this;
    }

    public RegistrationPage enterPasswordAndConfirmIt(String password) {
        driverActions.sendKeysToElement(password, PASSWORD_FIELD.by());
        driverActions.sendKeysToElement(password, CONFIRM_PASSWORD_FIELD.by());
        return this;
    }

    public void clickRegisterButton() {
        driverActions.clickOn(REGISTER_BUTTON.by());
    }

    public String getExistingEmailLabelText() {
        return driverActions.getElementText(EXISTING_EMAIL_LABEL.by());
    }
}

