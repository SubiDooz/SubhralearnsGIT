package examples;

import org.testng.annotations.Test;
import myutil.DataProviderClass;


public class DataProviderDiffClassExcelExample {
	
	
	@Test(dataProvider = "ExcelData", dataProviderClass = DataProviderClass.class)
	public void testDataProvider(String[] args) {
		System.out.println(args[0]+">>"+args[1]);
	}
	
	
}
