package examples;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class CustomUtil {

	public static void customSwitchToWindow(WebDriver driver) {

		String parentWindow = driver.getWindowHandle();
		Set<String> currentWindowSet = driver.getWindowHandles();

		for (String item : currentWindowSet) {
			if (!item.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(item);
				System.out.println("NewWindow : " + item);
			}
		}

	}

}
