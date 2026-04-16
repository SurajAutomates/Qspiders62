package utility;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	public Object[][] getDataFromMultipleColumns(String sheetname) throws EncryptedDocumentException, IOException {
		InputStream fis = Excel_utility.class.getClassLoader().getResourceAsStream("testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		short columnCount = sheet.getRow(0).getLastCellNum();
		Object[][] objArr = new Object[rowCount][columnCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				objArr[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return objArr;
		
	}
}
