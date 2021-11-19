package SeleniumActions.Pages;

import base.PageBase;
import org.openqa.selenium.By;

public class AuthenticationPage extends PageBase {
    /*
    Page Class contains all the used elements on specific page
    and the actions on these elements
     */
    By usernameTxtBox = By.name("username");
    By passwordTxtBox = By.name("password");
    By submitBtn = By.xpath("//button[@class='radius' and @type='submit']");

    public void Login(String username, String password) {
        locateElement(usernameTxtBox).sendKeys(username);
        locateElement(passwordTxtBox).sendKeys(password);
        locateElement(submitBtn).click();
    }


}
