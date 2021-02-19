package Tests;

import base.DriverContext;
import base.FrameworkInitialize;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class CheckAllLinksResponseCodes extends FrameworkInitialize {
    /*
    Check the response code and response messages for all the links on the Page under test
     */
    public static void VerifyLink(String urlLink) {
        try {
            URL link = new URL(urlLink);
            // Create connection using URL object
            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();
            // User getResponseCode() to get the response code
            if (httpConn.getResponseCode() == 200) {
                System.out.println(urlLink + " - " + httpConn.getResponseMessage() + " - " + httpConn.getResponseCode());
            } else if (httpConn.getResponseCode() == 404) {
                System.out.println(urlLink + " - " + httpConn.getResponseMessage() + " - " + httpConn.getResponseCode());
            } else {
                System.out.println(urlLink + " - " + httpConn.getResponseMessage() + " - " + httpConn.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void CheckLinksResponseCode() {
        List<WebElement> links = DriverContext.Driver.findElements(By.tagName("a"));
        System.out.println("Total links are  : " + links.size());
        for (WebElement element : links) {
            String url = element.getAttribute("href");
            VerifyLink(url);
        }
    }
}
