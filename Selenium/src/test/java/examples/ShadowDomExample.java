package examples;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomExample {

	@SuppressWarnings("unchecked")
	@Test
	public void handleShadowDom() throws InterruptedException {

		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("https://selectorshub.com/xpath-practice-page/");
		// driver.get("https://the-internet.herokuapp.com/");
		driver.get("http://watir.com/examples/shadow_dom.html");

		// WebElement internetHerokuMenuOption =
		// driver.findElement(By.xpath("//a[contains(text(),'Shadow')]"));

		Thread.sleep(5000);

		//JavascriptExecutor js = (JavascriptExecutor) driver;

		// Selectors hub' shadowhost
		// WebElement shadowHost =
		// driver.findElement(By.xpath("//div[@id='userName']"));

		// js.executeScript("arguments[0].scrollIntoView({'behavior':'smooth'})",
		// internetHerokuMenuOption);

		// internetHerokuMenuOption.click();

		// internet heroku shadow host
		// WebElement shadowHost = driver.findElement(By.xpath("//my-paragraph[1]"));

		// watir shadowHost
		WebElement shadowHost = driver.findElement(By.xpath("//div[@id='shadow_host']"));

		// Thread.sleep(2000);

		WebElement shadowRootEle = getShadowRootElement(driver, shadowHost);
		String text = shadowRootEle.findElement(By.cssSelector(".info")).getText();
		System.out.println(text);
		
	}

	@SuppressWarnings("unchecked")
	private WebElement getShadowRootElement(WebDriver driver, WebElement shadowHost) {
		WebElement returnObj = null;
		Object shadowRoot = ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", shadowHost);

		if (shadowRoot instanceof WebElement) {
			returnObj = (WebElement) shadowRoot;
		} else if (shadowRoot instanceof Map) {
			Map<String, Object> shadowRootObj = (Map<String, Object>) shadowRoot;
			System.out.println(shadowRootObj);
			System.out.println(shadowRootObj.keySet());
			String shadowRootKey = (String) shadowRootObj.keySet().toArray()[0];
			System.out.println(shadowRootKey);
			String id = (String) shadowRootObj.get(shadowRootKey);
			RemoteWebElement remoteWEObj = new RemoteWebElement();
			remoteWEObj.setParent((RemoteWebDriver) driver);
			remoteWEObj.setId(id);
			returnObj = remoteWEObj;
			
		} else {
			System.out.println("ShadowRoot neither WebElement or Map");
		}
		return returnObj;

	}

}
