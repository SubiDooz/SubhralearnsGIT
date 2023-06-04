package examples;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static final String browser = "chrome";
	public static final String Domain = "IN";
	public static String baseClassBN = null;
	public static String baseClassD = null;
	public static WebDriver driver = null;
	
	
	@BeforeTest
	@Parameters({"browserName","domain"})
	public static WebDriver setUpBrowser(@Optional(browser) String browserName, @Optional(Domain) String domain) {
		String browserNameFromSys = System.getProperty("browserName");
		String domFromSys = System.getProperty("domain");
		String testFlagFromSys = System.getProperty("testFlag");
		String domainSys = System.getenv("USERNAME");
		String envSys = System.getenv("USERDOMAIN");
		
		System.out.println(browserNameFromSys);
		System.out.println(domFromSys);
		System.out.println(testFlagFromSys);
		System.out.println(domainSys);
		System.out.println(envSys);
		
		
		if(browserNameFromSys!=null) {
			baseClassBN = browserNameFromSys;
		}else {
			baseClassBN = browserName;
		}
		if(domFromSys!=null) {
			baseClassD = domFromSys;
		}else {
			baseClassD = domain;
		}
		
		if(browserName.contains("c")) {
			driver = WebDriverManager.chromedriver().create();
			
		}else{
			driver = WebDriverManager.firefoxdriver().create();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
