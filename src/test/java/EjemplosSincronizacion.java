import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EjemplosSincronizacion {

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

	@Ignore
	@Test
	public void testWaitImplicito() {
		driver.get("http://localhost:8080");
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		WebElement btn = driver.findElement(By.id("btn-1"));
	}
	
	@Ignore
	@Test
	public void testWaitExplicito() {
		driver.get("http://localhost:8080");
		
		WebDriverWait espera = new WebDriverWait(driver, 7);
		WebElement boton = espera.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-1")));
		
		assertEquals("Pulsar", boton.getText());
	}
	
	@Test
	public void testFluentWait() {
		driver.get("http://localhost:8080");
		
		FluentWait<WebDriver> espera = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(7))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(Exception.class);
		
		//WebElement boton = espera.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-1")));
		WebElement boton2 = espera.until((driver) -> {
			return driver.findElement(By.id("btn-1"));
		});
		//assertEquals("Pulsar", boton.getText());
		assertEquals("Pulsar", boton2.getText());
	}
	
	
}