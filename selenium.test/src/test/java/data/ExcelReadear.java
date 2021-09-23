package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadear {
	
	
	
	static FileInputStream fis = null ;
	
	public FileInputStream getfileinputstream() throws FileNotFoundException {
	
	String filepath ="D:\\seleniumcourse\\eclipse\\selenium.test\\src\\test\\java\\data\\UserData.xlsx";
	File srcFile = new File(filepath);
	
		
		fis = new FileInputStream(srcFile);
	
	return fis;
	}
	




	
	public Object[][] getExcelData() throws IOException
	{
		fis = getfileinputstream(); 
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0); 
		
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 4 ; 
		
		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 
		
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString(); 
			}
		}
		
		workbook.close();
		return arrayExcelData; 
	}
}
