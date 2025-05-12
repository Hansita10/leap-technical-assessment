package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import commonmethods.HomePage_CommonMethod;
import poi.BookDetailsPage;
import poi.HomePage;

import org.openqa.selenium.WebDriver;
import utils.DriverRepo;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage home;
    protected BookDetailsPage details;
    protected HomePage_CommonMethod cm;
    
    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = DriverRepo.getDriver();
        home = new HomePage(driver);           // Initialized before each test
        details = new BookDetailsPage(driver);
        cm = new HomePage_CommonMethod(driver);
        driver.get("https://demoqa.com/books");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        DriverRepo.quitDriver();
    }
}