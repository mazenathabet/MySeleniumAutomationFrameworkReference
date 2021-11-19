package SeleniumActions.Tests;

import SeleniumActions.Pages.CheckBoxPage;
import SeleniumActions.Pages.HomePage;
import base.FrameworkInitialize;
import org.testng.annotations.Test;

public class PresenceOfAnElement extends FrameworkInitialize {

    /**
     *
     * Learn difference between:
     isDisplayed()  v/s  isEnabled()  v/s   isSelected()
     Notes:
     •	isDisplayed() is the method used to verify presence of a web element within the webpage.
     The method returns a “true” value if the specified web element is present on the web page and a “false” value if the web element is not present on the web page.
     •	isDisplayed() is capable to check for the presence of all kinds of web elements available.
     •	isEnabled() is the method used to verify if the web element is enabled or disabled within the webpage.
     •	isEnabled() is primarily used with buttons.
     •	isSelected() is the method used to verify if the web element is selected or not. isSelected()
     method is pre-dominantly used with radio buttons, dropdowns and checkboxes.
     *
     */

    @Test
    public void CheckElementPresence() {
        HomePage homePage = new HomePage();
        CheckBoxPage checkBoxPage = homePage.ClickOnCheckBoxLink();
        checkBoxPage.CheckElementPresence();
    }
}
