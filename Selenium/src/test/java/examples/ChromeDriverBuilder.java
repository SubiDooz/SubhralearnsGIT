package examples;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverBuilder {
	WebDriver driver = null;
	
	@BeforeMethod
	public WebDriver getDriver() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;


	}

}
