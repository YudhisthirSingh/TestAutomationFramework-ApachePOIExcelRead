package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadXLSdata {

	
	//logic for reading excel data in form od a 2-D array
	@DataProvider(name="testdata")
	public String[][] getData(Method m ) throws EncryptedDocumentException, IOException {
		
		
		String excelSheetName = m.getName();
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\data.xlsx");
			
		System.out.println("user.dir"+"\\src\\test\\resources\\testdata\\data.xlsx");
		
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook wb = WorkbookFactory.create(fis); 
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		int rows = sheetName.getLastRowNum();
		System.out.println(rows);
		
		Row rowCells  = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);
		
		
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String[rows][totalCols];

		for(int i = 1; i<=rows;i++) {
			for(int j = 0;j<totalCols;j++) {
				testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.print(testData[i-1][j]+"     ");
			}
			System.out.println();
		}
		
		return testData;
	
	}

}
