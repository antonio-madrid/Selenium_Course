import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EjemplosSeleniumGrid {

	private WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
	}

	@Before
	public void setUptest() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
		driver = new RemoteWebDriver(new URL("http://localhost:7777/wd/hub"), options);
	}

	@After
	public void tearDownTest() {
		driver.quit();
	}


	@Test
	public void testSuma() {
		driver.get(WikipediaPage.URL);
		WikipediaPage page = new WikipediaPage(driver);
		page.buscar("Selenium");
		assertEquals("Selenium", driver.findElement(By.id("firstHeading")).getText());

	}

}
