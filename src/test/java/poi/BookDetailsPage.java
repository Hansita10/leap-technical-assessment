package poi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDetailsPage {
    private WebDriver driver;

    public BookDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By bookTitle = By.id("title-wrapper");

    public String getBookTitle() {
        return driver.findElement(bookTitle).getText();
    }
}