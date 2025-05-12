package testscripts;

import base.BaseTest;
import commonmethods.HomePage_CommonMethod;
import org.testng.annotations.Test;
import dataprovider.ExcelDataProvider; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MiniBookStoreTest extends BaseTest {
		
	
	// Test Script for searching any book
    @Test(dataProvider = "searchAnyBookTest", dataProviderClass = ExcelDataProvider.class)
    public void searchAnyBookTest(String bookName) {
    	home.searchBook(bookName);
        HomePage_CommonMethod.waitForVisibility(driver, home.searchBox());

        List<WebElement> books = home.getBookTitles();
      //Explanation: Assert.assertEquals(actual, expected, "Optional failure message");
        assert books.size() > 0 : "No books found!";
        for (WebElement book : books) {
            System.out.println("Found Book: " + book.getText());
        }
    }

    // Test Script for searching a specific book
    @Test(dataProvider = "searchSpecificBookTest", dataProviderClass = ExcelDataProvider.class)
    public void searchSpecificBookTest(String bookName) {
       
        home.searchBook(bookName);
        HomePage_CommonMethod.waitForVisibility(driver, driver.findElement(By.id("searchBox")));

        String getBookname = driver.findElement(By.xpath("(//div[@role='gridcell'])[2]")).getText();
        //Explanation: Assert.assertEquals(actual, expected, "Optional failure message");
        assert getBookname.equals(bookName) : "Expected book not found.";
        cm.clickBookByTitle(bookName);
    }

    // Test Script for searching an invalid book
    @Test(dataProvider = "searchInvalidBook", dataProviderClass = ExcelDataProvider.class)
    public void searchInvalidBook(String bookName) {
    	home.searchBook(bookName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement noRows = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("rt-noData")));
        
      //Explanation: Assert.assertEquals(actual, expected, "Optional failure message");
        assert noRows.getText().equals("No rows found") : "'No rows found' was not displayed.";
    }
}