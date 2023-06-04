package examples;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

public class DesiredCapsAndOptions {
	
	
	@Test
	public void example() {
		WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		//options.addArguments("ignore-certificate-errors");
		
		options.merge(caps);
		
		//List<String> argList = new ArrayList<String>();
		//argList.add(0, "--start-maximized");
		//argList.add(1,"ignore-certificate-errors");
		
		//add arguments list
		//options.addArguments(argList);
		
		//options.setAcceptInsecureCerts(true);
		//options.addArguments("--headless");
		//options.setHeadless(true);
		
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://cacert.org");
		System.out.println("***********************************");
		System.out.println(options.getCapabilityNames());
		System.out.println(options.getBrowserName());
		System.out.println(options.getVersion());
		System.out.println(options.getPlatform());
	
		//driver.manage().timeouts().
	}

}
