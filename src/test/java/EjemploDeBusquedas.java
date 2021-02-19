import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemploDeBusquedas {
	
	@Test
	public void navegaAGoogle() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}
	

}
