package SeleniumActions.Pages;

import base.PageBase;
import org.openqa.selenium.By;

public class CheckBoxPage extends PageBase {

    public By Checkbox1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
    public By Checkbox2 = By.xpath("//*[@id=\"checkboxes\"]/input[2]");

    public void selectCheckBox() {
        locateElement(Checkbox1).click();
        if (locateElement(Checkbox2).isSelected()) {
            locateElement(Checkbox2).click();
        }
    }
    /*
    Check the status of the checkbox:
    - Is Displayed
    - Is Enabled
    - Is Selected
     */
    public void CheckElementPresence() {
        if (locateElement(Checkbox2).isDisplayed()) {
            locateElement(Checkbox2).click();
        }
        if (locateElement(Checkbox1).isEnabled()) {
            locateElement(Checkbox1).click();
        }
        if (locateElement(Checkbox2).isSelected()) {
            locateElement(Checkbox2).click();
        }
    }
}
