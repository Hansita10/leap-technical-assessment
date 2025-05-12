package dataprovider;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class ExcelDataProvider {

    // DataProvider for "searchAnyBookTest"
    @DataProvider(name = "searchAnyBookTest")
    public Object[][] getsearchAnyBookTest() throws Exception {
        return ExcelUtils.getRowData("src/test/resources/TestData.xlsx", "Books", "searchAnyBookTest");
    }

    // DataProvider for "searchSpecificBookTest"
    @DataProvider(name = "searchSpecificBookTest")
    public Object[][] getsearchSpecificBookTest() throws Exception {
        return ExcelUtils.getRowData("src/test/resources/TestData.xlsx", "Books", "searchSpecificBookTest");
    }

    // DataProvider for "invalidBookSearchData"
    @DataProvider(name = "searchInvalidBook")
    public Object[][] getsearchInvalidBook() throws Exception {
        return ExcelUtils.getRowData("src/test/resources/TestData.xlsx", "Books", "searchInvalidBook");
    }
}