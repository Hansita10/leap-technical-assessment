package commonmethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage_CommonMethod {
	
	WebDriver driver;
    private By searchBox = By.id("searchBox");
    private By bookTitles = By.cssSelector(".action-buttons a");
    
 // Constructor to initialize the WebDriver
    public HomePage_CommonMethod(WebDriver driver) {
        this.driver = driver;
    }
    
    public static void waitForVisibility(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
	
    /*Method to search for a book*/
	public void searchBook(String bookTitle) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.clear();
        searchInput.sendKeys(bookTitle);
    }
	
	

	/* Method to click on a book */
	
	public void clickBookByTitle(String bookTitle) {
        String xpath = "//a[normalize-space()='" + bookTitle + "']";
        WebElement bookLink = driver.findElement(By.xpath(xpath));
        bookLink.click();
    }
	
	/* Method to get 1st Book title */
	public String getFirstBookTitle() {
        List<WebElement> books = driver.findElements(bookTitles);
        if (!books.isEmpty()) {
            return books.get(0).getText();
        } else {
            throw new RuntimeException("No books found.");
        }
    }
}
