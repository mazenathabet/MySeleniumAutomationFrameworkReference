package SeleniumActions.Pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class DropdownPage extends PageBase {

    public By Dropdown = By.xpath("//select[@id='dropdown']");

    /*
    To perform actions on the Dropdown element we should use the Select library
     */
    Select select = new Select(locateElement(Dropdown));
    /*
    we can select an element in the dropdown list By:
    - Visible text on the page
    - Index of the element on the DOM
    - Value of the element on the DOM
    - Or get first selected option
     */
    public void selectByVisibleText(String Text) {
        select.selectByVisibleText(Text);
    }
    public void selectByIndex(Integer index) {
        select.selectByIndex(index);
    }
    public void selectFirstSelectedOption() {
        select.getAllSelectedOptions();
    }
    public void selectByValue(String value) {
        select.selectByValue(value);
    }
}
