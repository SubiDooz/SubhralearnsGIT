package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TextBox extends ChromeDriverBuilder{
	
	@Test
	public void example() throws InterruptedException {
		driver.get("https://google.com");
		Thread.sleep(2000);
		//entering name and then hitting Enter for search
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium");
		Actions ac = new Actions(driver);
//		ac.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		//clearing entered value
		driver.findElement(By.name("q")).clear();
		Thread.sleep(2000);
		
		//entering value caps lock
		driver.findElement(By.name("q")).sendKeys(Keys.SHIFT,"Selenium");
		
		//clearing entered value
		driver.findElement(By.name("q")).clear();
		Thread.sleep(2000);
		
		ac.moveToElement(searchBox).click().sendKeys("Selenium").
		doubleClick().contextClick().build().perform();
		Thread.sleep(2000);
		
		
		//two ways of getting the text from the text box
		System.out.println(driver.findElement(By.name("q")).getText());
		System.out.println(driver.findElement(By.name("q")).getAttribute("value"));
	}

}
