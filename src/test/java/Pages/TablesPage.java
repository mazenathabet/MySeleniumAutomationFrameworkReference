package Pages;

import base.DriverContext;
import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TablesPage extends PageBase {

    WebElement webTable = DriverContext.Driver.findElement(By.id("table1"));
    /*
    Selecting an option or specific cell on the table can be performed when selecting a specific date from a table calendar
     */
    public void webTableTest() {
        // Get all rows at table 1 ( rows = tr )
        List<WebElement> rows = webTable.findElements(By.tagName("tr"));
        Assert.assertEquals(5, rows.size(), "The Rows number is incorrect");
        // Get all Cells data (cols and rows) ( cols = td )
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.println(col.getText() + "\t");
            }
            // To Print Empty line between each row
            System.out.println();
        }
    }
}
