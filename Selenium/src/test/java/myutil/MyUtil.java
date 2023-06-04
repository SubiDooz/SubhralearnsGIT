package myutil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import examples.BaseTest;

public class MyUtil {
	
	public static WebElement getElementByXpath(String xpath) {
		
		System.out.println("inside my custom method");
		return BaseTest.driver.findElement(By.xpath(xpath));
		
	}

}
