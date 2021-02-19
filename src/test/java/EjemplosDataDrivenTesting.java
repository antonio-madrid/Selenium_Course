import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class EjemplosDataDrivenTesting {

	private WebDriver driver;
	private String n1;
	private String n2;
	private String res;
	
	@Parameters
	public static List<String[]> getData() {
		return Arrays.asList(new String[][] {
			{"1", "2", "3" },
			{"3", "10", "13" },
			{"4", "6", "10" },
			{"8", "1", "9" }
		});
	}
	
	public EjemplosDataDrivenTesting(String n1, String n2, String res) {
		this.n1 = n1;
		this.n2 = n2;
		this.res = res;
	}

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
		driver.get("http://localhost:8080");
		
		WebElement input1 = driver.findElement(By.id("n1"));
		WebElement input2 = driver.findElement(By.id("n2"));
		WebElement botonSumar = driver.findElement(By.id("btn-suma"));
		
		input1.sendKeys(this.n1);
		input2.sendKeys(this.n2);
		botonSumar.click();
		
		WebElement spanResultado = driver.findElement(By.id("res"));
		assertEquals(this.res, spanResultado.getText());
	}

	
	
}