package examples;


import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import myutil.MyUtil;

public class SortableWebTableExample extends BaseTest{

	@Test
	public void validateSortableWebTable() throws InterruptedException {
		
		InitialPage.setUpURL(driver);
		Thread.sleep(5000);
		//WebElement sdt = driver.findElement(By.xpath("//a[contains(text(),'Sortable')]"));
		
		//custom method from Util class to find webelement
		WebElement sdt = MyUtil.getElementByXpath("//a[contains(text(),'Sortable')]");
		
		sdt.click();
		Thread.sleep(2000);
		
		//Code to retrieve web table last name value before sorting
		List<WebElement> lastNameEleList1 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));
		List<String> lastNamesBeforeSorting = lastNameEleList1.stream().map(ele->ele.getText()).collect(Collectors.toList());
		
		
		//code to click on the sortable table header
		WebElement tableHeader = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[1]"));
		tableHeader.click();
		Thread.sleep(5000);
		
		//Code to retrieve web table last name value before sorting
		List<WebElement> lastNameEleList2 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));
		List<String> lastNamesAfterSorting = lastNameEleList2.stream().map(ele->ele.getText()).collect(Collectors.toList());
		
		//Assert both are different sorting
		Assert.assertTrue(!lastNamesBeforeSorting.equals(lastNamesAfterSorting));
		
		
	}
	
}
