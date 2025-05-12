package poi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import commonmethods.HomePage_CommonMethod;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBox = By.id("searchBox");
    private By bookTitles = By.cssSelector(".rt-tr-group .rt-td:nth-child(2)");
    private By specificBook = By.xpath("//a[normalize-space()='Git Pocket Guide']");

    public void waitForSearchBox() {
        WebElement searchInput = driver.findElement(searchBox);
        HomePage_CommonMethod.waitForVisibility(driver, searchInput);
    }

    public void searchBook(String bookName) {
        WebElement input = driver.findElement(searchBox);
        input.clear();
        input.sendKeys(bookName);
    }

    public List<WebElement> getBookTitles() {
        return driver.findElements(bookTitles);
    }
    
    public WebElement searchBox() {
    	return driver.findElement(By.id("searchBox"));
    }

    
    
    public WebElement getSpecificBook() {
        return driver.findElement(specificBook);
    }
}