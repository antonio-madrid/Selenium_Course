import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemploChrome {
	
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
	public void navegaAGoogle() {
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		
		WebElement inputWikipedia = driver.findElement(By.id("searchInput"));
	}
	
	@Ignore
	@Test
	public void buscarPorName() {
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		WebElement inputWikipedia = driver.findElement(By.name("search"));
		
	}
	
	
	@Ignore
	@Test
	public void buscarPorClase() {
		driver.get("https://resting.onrender.com/");
		List<WebElement> botones = driver.findElements(By.className("css-j13a3q"));
		
		assertEquals(5, botones.size());
		
	}
	
	
	@Test
	public void buscarPorEtiqueta() {
		driver.get("https://resting.onrender.com/");
		List<WebElement> botones = driver.findElements(By.tagName("button"));
		assertEquals(7, botones.size());
	}
	

	@Test
	public void buscarEnlacesDentroHerramientas() {
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		WebElement bloqueHerramientas = driver.findElement(By.id("p-tb"));
		
		List<WebElement> enlacesHerramientas = bloqueHerramientas.findElements(By.tagName("a"));
		assertEquals(8, enlacesHerramientas.size());
	}
	
	@Test
	public void buscarPorTextoEnlace() {
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		WebElement enlaceAcceder = driver.findElement(By.linkText("Acceder"));
		WebElement enlaceCrearUnaCuenta = driver.findElement(By.linkText("Crear una"));
		
		
	}
	
}
