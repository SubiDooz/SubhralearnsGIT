package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class PageRefresh extends ChromeDriverBuilder{
	
	@Test
	public void examples() throws InterruptedException {
		driver.get("https://google.com");
		Thread.sleep(3000);
		/*driver.navigate().refresh();
		Thread.sleep(3000);
		driver.get(driver.getCurrentUrl());
		Thread.sleep(3000);
		driver.navigate().to(driver.getCurrentUrl());
		Thread.sleep(3000);*/
		
		//does not work to refresh page
		driver.findElement(By.name("q")).sendKeys(Keys.F5);
		Thread.sleep(3000);
		
	}
}
