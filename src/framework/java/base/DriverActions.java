package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DriverActions extends DriverContext {

    WebDriverWait wait = new WebDriverWait(DriverContext.Driver, Duration.ofSeconds(30));

    public void openUrl(String Url) {
        Driver.get(Url);
    }

    public void clickOn(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void clickOn(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        Driver.findElement(by).click();
    }

    public void sendKeysToElement(String value, WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void sendKeysToElement(String value, By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Driver.findElement(by).clear();
        Driver.findElement(by).sendKeys(value);
    }

    public void sendKeyChords(String value, Keys keys, WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(value, keys);
    }

    public void sendKeyChords(String value, Keys keys, By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Driver.findElement(by).clear();
        Driver.findElement(by).sendKeys(value, keys);
    }

    public void sendKeysWithoutClear(String value, WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(value);
    }

    public void sendKeysWithoutClear(String value, By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Driver.findElement(by).sendKeys(value);
    }


    public String getTitle() {
        return Driver.getTitle();
    }

    public void switchToIframe(int index) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
        Driver.switchTo().frame(index);
    }

    public void switchToIframe(String idOrName) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
        Driver.switchTo().frame(idOrName);
    }

    public void switchToIframe(WebElement webElement) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
        Driver.switchTo().frame(webElement);
    }

    public void switchToIframe(By by) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        Driver.switchTo().frame(Driver.findElement(by));
    }

    public void switchToDefaultContent() {
        Driver.switchTo().defaultContent();
    }

    public void selectByIndex(By by, int index) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        final Select dropdown = new Select(Driver.findElement(by));
        dropdown.selectByIndex(index);
    }

    public void selectByVisibleText(By by, String visibleText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        final Select dropdown = new Select(Driver.findElement(by));
        dropdown.selectByVisibleText(visibleText);
    }

    public void selectByValue(By by, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        final Select dropdown = new Select(Driver.findElement(by));
        dropdown.selectByValue(value);
    }


    public String getElementAttribute(By by, String attribute) {
        return Driver.findElement(by).getAttribute(attribute);
    }

    /**
     * Check if an alert is present in the windowhandles and return a boolean if it
     * exist and not if not
     *
     * @return Boolean with tru if alert exist, false if not
     */
    public boolean isAlertPresent() {
        try {
            Driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    /**
     * If an alert is present (exist), switch to it and accept it
     */
    public void acceptAlert() {
        if (isAlertPresent()) {
            Driver.switchTo().alert().accept();
        }
    }

    /**
     * If an alert is present (exist), switch to it and close it
     */
    public void closeAlert() {
        if (isAlertPresent()) {
            Driver.switchTo().alert().dismiss();
        }
    }

    /**
     * If an prompt alert is present (exist), switch to it , type text and accept it
     */
    public void sendTextToPromptAlertAndAccept(String text) {
        if (isAlertPresent()) {
            Alert alert = Driver.switchTo().alert();
            alert.sendKeys(text);
            alert.accept();
        }
    }

    /**
     * Scrolls the page until the given element is visible
     *
     * @param by From the element we want to operate
     */
    public void scrollToElement(By by) {
        ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", Driver.findElement(by));
    }

    /**
     * positive pixels means scrolling down, negative means up
     *
     * @param pixels -> number of pixels to scroll
     */
    public void scrollPage(int pixels) {
        ((JavascriptExecutor) Driver).executeScript("scroll(0, " + pixels + ");");
    }

    public void scrollPageBy(int pixels) {
        ((JavascriptExecutor) Driver).executeScript("window.scrollBy(0, " + pixels + ");");
    }

    public void dragElementOverElement(WebElement firstElement, WebElement targetElement) {
        Actions action = new Actions(Driver);
        action.dragAndDrop(firstElement, targetElement).perform();
    }

    public void clearField(By by) {
        Driver.findElement(by).clear();
    }

    /**
     * Read an alert containing text
     *
     * @return innerText of the alert element.
     */
    public String readAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        return Driver.switchTo().alert().getText();
    }

    public String getElementAttribute(WebElement webElement, String attribute) {
        return webElement.getAttribute(attribute);
    }

    public String getElementText(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return Driver.findElement(by).getText();
    }

    public String getElementText(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public String getCurrentUrl() {
        return Driver.getCurrentUrl();
    }

    /**
     * Delete all cookies from actual browser
     */
    public void deleteAllCookies() {
        Driver.manage().deleteAllCookies();
    }

    /**
     * Look for if a element is present or not in the frame/window and return a
     * true/false answer
     *
     * @param by Element to look for
     * @return true if the element is located, false if the element
     */
    public boolean elementExists(By by) {
        return Driver.findElements(by).size() > 0;
    }

    /**
     * Perform an action to double click an element
     *
     * @param element Where we want to click
     */
    public void doubleclickWebElement(WebElement element) {
        Actions action = new Actions(Driver);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        action.doubleClick(element).build().perform();
    }

    /**
     * Perform an action to double click an element
     *
     * @param by is a locator expression
     */
    public void doubleclickBy(By by) {
        Actions action = new Actions(Driver);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        action.doubleClick(Driver.findElement(by)).build().perform();
    }

    /**
     * Test the state of visibility of an element and return a boolean, true if
     * visible, false if not
     *
     * @param by from the desired element
     * @return return true if visible, false if not
     */
    public boolean isElementDisplayed(By by) {
        if (elementExists(by)) {
            WebElement we = Driver.findElement(by);
            return we.isDisplayed();
        } else {
            return false;
        }
    }

    /**
     * Test the element is selected or not  of an element and return a boolean, true if
     *
     * @param by from the desired element
     * @return return true if visible, false if not
     */
    public boolean isSelected(By by) {
        if (elementExists(by)) {
            WebElement we = Driver.findElement(by);
            return we.isSelected();
        } else {
            return false;
        }
    }

    /**
     * Test the element is enabled or not  of an element and return a boolean, true if
     *
     * @param by from the desired element
     * @return return true if visible, false if not
     */
    public boolean isEnabled(By by) {
        if (elementExists(by)) {
            WebElement we = Driver.findElement(by);
            return we.isEnabled();
        } else {
            return false;
        }
    }

    /**
     * Check from a list getted from the locator if each one of the elements
     * contains a certain text/feature/property. Returns true if it does, false if
     * not
     *
     * @param locator from the list of items we want to check
     * @param element element we want to check if it's inside in every item
     * @return return true if the element exisit in every item from the list, false
     * if not
     */
    public boolean searchElementInEveryRow(Locator locator, String element) {
        List<WebElement> elements = Driver.findElements(locator.by());
        for (WebElement e : elements) {
            if (!e.getText().toUpperCase().contains(element.toUpperCase())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Move to the element located by the by and then press the right click button
     * inside this element
     *
     * @param by from the element to use
     */
    public void rightClick(By by) {
        WebElement we = Driver.findElement(by);
        scrollToElement(by);
        Actions action = new Actions(Driver);
        action.moveToElement(we);
        action.contextClick(we).build().perform();
    }

    /**
     * Returns the quantity of elements that are specified by the locator supplied
     *
     * @param locator that specifies or not some elements
     * @return number of elements located bt locator
     */
    public int getElementsSize(Locator locator) {
        return Driver.findElements(locator.by()).size();
    }

    public int getElementsSize(By by) {
        return Driver.findElements(by).size();
    }
}
