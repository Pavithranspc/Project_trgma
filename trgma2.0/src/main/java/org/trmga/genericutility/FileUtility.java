package org.trmga.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains all the logics to read data from external files.
 * properties file
 * excel file
 * @author TYSS Pavithran
 */
public class FileUtility {
	/**
	 * this method is used to read data from properties file.
	 * Pass String key as argument.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertiesFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");

		//create object for Properties class
		Properties prop = new Properties();
		
		//load fis to prop
		prop.load(fis);
		
		//fetch data from properties file
		String result = prop.getProperty(key);
		
		//return the result
		return result;
		
	}
	
	/**
	 * This method is used to read data from excel file.
	 * Pass Sheet Name, Row Number, Cell Number as parameters.
	 * @param SheetName
	 * @param RowNum
	 * @param CellNum
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String SheetName, int RowNum, int CellNum) throws FileNotFoundException,IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		String value = wb.getSheet(SheetName).getRow(RowNum).getCell(CellNum).getStringCellValue();
		
//		wb.close();
		
		return value;
		
	}
	
	
}
