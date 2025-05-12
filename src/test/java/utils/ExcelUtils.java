package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

	public static Object[][] getRowData(String filePath, String sheetName, String testCaseId) throws IOException {
	    FileInputStream fis = new FileInputStream(filePath);
	    Workbook workbook = WorkbookFactory.create(fis);
	    Sheet sheet = workbook.getSheet(sheetName);

	    int rowCount = sheet.getPhysicalNumberOfRows();
	    int colCount = sheet.getRow(0).getLastCellNum();

	    for (int i = 1; i < rowCount; i++) {
	        Row row = sheet.getRow(i);
	        if (row == null || row.getCell(0) == null) continue;

	        String tcId = row.getCell(0).toString().trim();
	        if (tcId.equalsIgnoreCase(testCaseId)) {
	            Object[][] data = new Object[1][colCount - 1];
	            for (int j = 1; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                data[0][j - 1] = (cell == null) ? "" : cell.toString().trim();
	            }
	            workbook.close();
	            fis.close();
	            return data;
	        }
	    }

	    workbook.close();
	    fis.close();
	    throw new IllegalArgumentException("No data found for test case: " + testCaseId);
	}
}