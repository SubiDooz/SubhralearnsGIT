package examples;
import org.openqa.selenium.WebDriver;

import testClass.CommonProperties;

public class InitialPage {

	public static void setUpURL(WebDriver driver) throws InterruptedException {
		String urlToLoad = baseURLPrepare();
		driver.get(urlToLoad);
		Thread.sleep(5000);

	}

	private static String baseURLPrepare() {
		String domValFromBaseTest = BaseTest.baseClassD;

		String baseURLFromIP = domValFromBaseTest + "DOM";

		switch (baseURLFromIP) {

		case "GLOBALDOM":
			baseURLFromIP = CommonProperties.GLOBALDOM;
			break;

		case "INDIADOM":
			baseURLFromIP = CommonProperties.INDIADOM;
			break;
			
		case "internetDOM":
			baseURLFromIP = CommonProperties.internetDOM;
			break;
		}

		return baseURLFromIP;
	}

}
