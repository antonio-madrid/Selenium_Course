import java.util.ArrayList;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */

/**
 * @author a.a.jimenez.madrid
 *
 */
public class EjemploConChrome {
	
	@Test 
	public void miFuncion() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https:www.google.com");
	}
}
