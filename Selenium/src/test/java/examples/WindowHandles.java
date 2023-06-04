package examples;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles extends BaseTest{
	
	@Test
	public void validate() throws InterruptedException {
		
		InitialPage.setUpURL(driver);
		WebElement element = driver.findElement(By.xpath("//a[@aria-label='Google apps']"));
		
		element.click();
		
		Thread.sleep(5000);
		
		
		WebElement iframe = driver.findElement(By.name("app"));
		driver.switchTo().frame(iframe);	
		
		
		WebElement gmail = driver.findElement(By.xpath("//span[text()='Gmail']"));
		
		Actions ac = new Actions(driver);
		
		ac.moveToElement(gmail).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(2000);		
		
		
		WebDriverWait wait = new WebDriverWait(driver,5);
//		wait.until(ExpectedConditions.visibilityOf(element));
//		
//		
//		//Thread.sleep(5000);
//		
//		Actions ac = new Actions(driver);
//		
//		ac.moveToElement(element).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
//		Thread.sleep(2000);
//		
		CustomUtil.customSwitchToWindow(driver);
//		
//		
		WebElement eleToWaitForInNewWindow = driver.findElement(By.xpath("//a[text()='Sign in']"));
		
		
		wait.until(ExpectedConditions.visibilityOf(eleToWaitForInNewWindow));
		
		CustomUtil.customSwitchToWindow(driver);
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
		System.out.println("WhichWindow? : "+driver.getWindowHandle());
		
	}
	
	
	
	
}
