import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemplosPOM {

	private WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
	}

	@Before
	public void setUptest() {
		driver = new ChromeDriver();
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
