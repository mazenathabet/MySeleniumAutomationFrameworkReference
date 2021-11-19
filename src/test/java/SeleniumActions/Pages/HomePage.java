package SeleniumActions.Pages;

import base.PageBase;
import org.openqa.selenium.By;

public class HomePage extends PageBase {
    By AuthenticationLink = By.linkText("Form Authentication");
    By CheckBoxLink = By.linkText("Checkboxes");
    By DropdownLink = By.linkText("Dropdown");
    By TablesLink = By.linkText("Sortable Data Tables");

    /*
    Page Navigation -Is the relation between the pages ,so that , anytime while an operation is performed on one method
    it may return a page object we should return that page as following
     */
    public AuthenticationPage AuthenticationLink() {
        locateElement(AuthenticationLink).click();
        return new AuthenticationPage();
    }
    public CheckBoxPage ClickOnCheckBoxLink() {
        locateElement(CheckBoxLink).click();
        return new CheckBoxPage();
    }
    public DropdownPage ClickOnDropDownLink() {
        locateElement(DropdownLink).click();
        return new DropdownPage();
    }
    public TablesPage ClickOnTableLink() {
        locateElement(TablesLink).click();
        return new TablesPage();
    }
}
