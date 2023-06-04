package examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitExample extends ChromeDriverBuilder{
	
	@Test
	public void example() {
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.cssSelector("div#checkbox input")).click();
		driver.findElement(By.cssSelector("form#checkbox-example button")).click();
		
		WebDriverWait exWait = new WebDriverWait(driver, 2);
		WebElement actual = exWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("form#checkbox-example p#message"))));
		
		Assert.assertTrue(actual.isDisplayed());
	}
}
