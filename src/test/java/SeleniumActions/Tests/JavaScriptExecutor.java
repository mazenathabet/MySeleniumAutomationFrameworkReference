package SeleniumActions.Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutor extends FrameworkInitialize {

    @BeforeMethod
    public void goToAmazonSite() {
        DriverContext.Driver.get("https://www.amazon.com/");
    }

    /**
     * We need to use JavaScriptExecutor when a scroll down on the Page
     * starts from 0 to 4000
     */
    WebElement randomElement;
    WebElement CalenderDate = DriverContext.Driver.findElement(By.id("ctl00_mainContent_txt_FromDate"));
    String dateVal = "30-12-2017";
    @Test
    public void JsActions(){
        drawBorder(randomElement); //draw a border
        flash(randomElement); //highlight an element
        System.out.println(getPageInnerText()); //Get all the page inner text
        scrollIntoView(randomElement); // scroll down the page to specific element
        ScrollDownUsingJavaScriptExecutor(); // scroll down to specific
        refreshBrowserByJS(); // Refresh the page using JavaScriptExecutor
        System.out.println(getTitleByJS());// Print Page's title using JavaScriptExecutor
        selectDateByJS(CalenderDate, dateVal); // set Date attribute to specific date using Jse
    }

    public static void ScrollDownUsingJavaScriptExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) DriverContext.Driver;
        js.executeScript("scrollBy(0,4000)");
    }
    /**
     * Scroll down the page to specific Element
     */
    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) DriverContext.Driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    /**
     * To get all the page inner Texts
     */
    public static String getPageInnerText() {
        JavascriptExecutor js = ((JavascriptExecutor) DriverContext.Driver);
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }
    /**
     * To Draw a border around the element
     */
    public static void drawBorder(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) DriverContext.Driver);
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
    /**
     * To Highlight the element with specific color
     */
    public static void flash(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) DriverContext.Driver);
        String bgColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,200,0)", element);
            changeColor(bgColor, element);
        }
    }
    public static void changeColor(String color, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) DriverContext.Driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
    }
    /**
     * Refresh the page with JavaScriptExecutor
     */
    public static void refreshBrowserByJS(){
        JavascriptExecutor js = ((JavascriptExecutor) DriverContext.Driver);
        js.executeScript("history.go(0)");
    }
    /**
     * Get Page title using JavaScriptExecutor
     */
    public static String getTitleByJS(){
        JavascriptExecutor js = ((JavascriptExecutor) DriverContext.Driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    /**
     * Set Calender's Date to specific date using JSE
     */
    public static void selectDateByJS(WebElement element, String dateVal){
        JavascriptExecutor js = ((JavascriptExecutor) DriverContext.Driver);
        js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);

    }

}
