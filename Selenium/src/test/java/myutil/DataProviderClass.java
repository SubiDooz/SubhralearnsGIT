package myutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	final String filePath = "C:\\Users\\soumi\\Documents\\Subhro Personal\\";
	final String fileName = "TestDataExcel.xlsx";
	 final String sheetName = "Login";
	
	@SuppressWarnings("hiding")
	@DataProvider(name="ExcelData")
	public Object[][] readExcel(){
		
		String location = filePath+fileName;
		String[][] returnableObj = null;
		
		try {
			FileInputStream fis = new FileInputStream(location);
			XSSFWorkbook wbObj = new XSSFWorkbook(fis);
			XSSFSheet wsheetObj = wbObj.getSheet(sheetName);
			System.out.println(wsheetObj.getPhysicalNumberOfRows());
			String valZeroZero = wsheetObj.getRow(0).getCell(0).getStringCellValue();
			String valZeroOne = wsheetObj.getRow(0).getCell(1).getStringCellValue();
			System.out.println(valZeroZero + ">>" + valZeroOne);
			
			//String[][] twoDimentioanlObj = {{valZeroZero}, {valZeroOne}};
			String[][] twoDimentioanlObj = new String[2][2];
			twoDimentioanlObj[0][0]=valZeroZero;
			twoDimentioanlObj[0][1]=valZeroOne;
			twoDimentioanlObj[1][0]=valZeroZero;
			twoDimentioanlObj[1][1]=valZeroOne;
						
			System.out.println(twoDimentioanlObj);
			returnableObj = twoDimentioanlObj;
			
			wbObj.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		return returnableObj;
		
	}
	

}
