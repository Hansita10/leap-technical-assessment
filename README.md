# LEAP Technical Assessment – Mini Bookstore Automation

This is a Maven + TestNG framework for automating the Mini Bookstore site at [https://demoqa.com/books](https://demoqa.com/books).

---

## ✅ Project Features

- Java + Selenium WebDriver
- TestNG for test management
- Page Object Model (POM)
- Data-driven testing using Excel + Apache POI
- Custom utility classes for WebDriver and Excel
- Negative and positive UI test cases
- Fully scalable and CI/CD compatible

---

Folder Structure
Minibookstore-testscripts/
├── base/
├── commonmethods/
├── dataprovider/
├── poi/
├── testscripts/
├── utils/
├── resources/
└── testng.xml

How to Run Tests

Prerequisites
- Java 11+
- Maven 3.6+
- Chrome browser

Run Test by mvn test or run via testng.xml inside your IDE.

Book names are read from TestData.xlsx via ExcelDataProvider.java.
You can modify test data in src/test/resources/TestData.xlsx.
