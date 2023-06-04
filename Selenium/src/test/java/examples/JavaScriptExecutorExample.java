package examples;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorExample {

	WebDriver driver=null;
	
	@Test
	public void example() throws InterruptedException {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.get("https://the-internet.herokuapp.com/");

		driver.get("https://www.axisbank.com/");
		Thread.sleep(2000);
		
		closeHomePageModalUponLoading("div#screen_takeover");
		clickWhenBuinessTabPresent("//a[text()='Business']");
		//clickOpenNewTabIfAxisLogoPresent();
		switchToNewWindow();
		fetchCurrentURL();
		scrollToEnd();
		
		
		// findDataLayers(driver);

		// WebElement infiniteScrollEle =
		// driver.findElement(By.xpath("//a[contains(text(),'Infinite Scroll')]"));

		// JavascriptExecutor js = (JavascriptExecutor) driver;

//		//javascript scrollIntoView method
//		js.executeScript("arguments[0].scrollIntoView({'behavior':'smooth'})", infiniteScrollEle);
//		// javascript click
//		js.executeScript("arguments[0].click()", infiniteScrollEle);

		// javascript scroll method
//		js.executeScript("arguments[0].scroll(0,600)", infiniteScrollEle);
//		js.executeScript("arguments[0].scroll({'top':600, 'left':0, 'behavior':'smooth'})", infiniteScrollEle);
//		js.executeScript("arguments[0].click()", infiniteScrollEle);

		// custome method which takes a driver and webelement as arguments and perform
		// scrolling
		// scrollByJavaScriptAndClick(driver, infiniteScrollEle);

	}

	private void scrollToEnd() throws InterruptedException {
		performScrolling();
		Thread.sleep(5000);
		
	}

	private void performScrolling() {
		Actions ac = new Actions(driver);
		ac.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
	}

	private void clickWhenBuinessTabPresent(String locator) {
		WebElement ele = captureWEByXpath(locator);
		clickOpensNewTab(ele);
	}

	private WebElement captureWEByXpath(String locator) {
		return driver.findElement(By.xpath(locator));
		
	}

	private void fetchCurrentURL() {
		//driver.getCurrentUrl();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String currentURL = js.executeScript("return document.URL").toString();
		System.out.println(currentURL);
	}

	private void clickOpenNewTabIfAxisLogoPresent() throws InterruptedException{
		WebElement axisLogo = captureWEByCss("img[alt='Axis Bank logo']");
		clickOpensNewTab(axisLogo);
		Thread.sleep(5000);
	}

	private void clickOpensNewTab(WebElement ele) {
		if (ele!=null & ele.isDisplayed()) {
			performRightClickOnElement(ele);
			
		} else {
			System.out.println("Logo not displayed");
		}
		
	}

	private void performRightClickOnElement(WebElement ele) {
		Actions ac = new Actions(driver);
		ac.keyDown(Keys.CONTROL).click(ele).build().perform();
		System.out.println("Should open a new tab now");
	}

	private void switchToNewWindow() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		
		for (String currWindow : windows) {
			if(!currWindow.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(currWindow);
			}
		}
		
		Thread.sleep(2000);
	}

	private void closeHomePageModalUponLoading(String locator) {
		WebElement ele = captureWEByCss(locator);
		List<WebElement> closeBtns = captureWEByCss(ele, "div.close_button");
		
		if(closeBtns.size()<2) {
			closeBtns.get(0).click();
			System.out.println("Clicked on the modal");
		}else {
			System.out.println("More than one close button on the modal");
		}
	}

	private WebElement captureWEByCss(String locator) {
		return driver.findElement(By.cssSelector(locator));

	}
	
	private List<WebElement> captureWEByCss(WebElement ele, String locator) {
		return ele.findElements(By.cssSelector(locator));

	}

	private void findDataLayers(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object x = js.executeScript("return dataLayer");
		System.out.println(x);
		
	}

	private void scrollByJavaScriptAndClick(WebDriver driver, WebElement infiniteScrollEle) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({'behavior':'smooth'})", infiniteScrollEle);
		js.executeScript("arguments[0].click()", infiniteScrollEle);

	}

}
