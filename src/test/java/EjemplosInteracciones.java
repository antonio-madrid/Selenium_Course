import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class EjemplosInteracciones {

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
	public void escribirInput() {
		driver.get("https://resting.onrender.com/");

		WebElement inputTitulo = driver.findElement(By.cssSelector("input.css-qzovtw"));
		inputTitulo.sendKeys("Descanso");
		inputTitulo.clear();
		inputTitulo.sendKeys("Curso de ...");

		assertEquals("Curso de ...", inputTitulo.getAttribute("value"));
	}

	@Ignore
	@Test
	public void submitFormulario() {
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

		WebElement inputBuscar = driver.findElement(By.id("searchInput"));
		inputBuscar.sendKeys("selenium");
		inputBuscar.submit();

		WebElement tituloPagina = driver.findElement(By.id("firstHeading"));
		assertEquals("Selenium", tituloPagina.getText());
	}

	@Ignore
	@Test
	public void submitFormularioConClick() {
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

		WebElement inputBuscar = driver.findElement(By.id("searchInput"));
		inputBuscar.sendKeys("selenium");
		inputBuscar.submit();

		WebElement botonBuscar = driver.findElement(By.name("go"));
		botonBuscar.click();

		WebElement tituloPagina = driver.findElement(By.id("firstHeading"));
		assertEquals("Selenium", tituloPagina.getText());
	}

	@Ignore
	@Test
	public void labCajaText2() {
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

		WebElement inputBuscar = driver.findElement(By.id("searchInput"));
		assertEquals("Buscar en Wikipedia", inputBuscar.getAttribute("placeholder"));
		assertEquals("13px", inputBuscar.getCssValue("font-size"));
	}

	@Ignore
	@Test
	public void testSelect() {
		driver.get("http://localhost:8080");

		WebElement desplegable = driver.findElement(By.id("listaCoches"));
		Select desplegableCoches = new Select(desplegable);

		desplegableCoches.selectByIndex(1);
		assertEquals("Audi", desplegableCoches.getFirstSelectedOption().getText());

		desplegableCoches.selectByValue("mercedes");
		assertEquals("Mercedes", desplegableCoches.getFirstSelectedOption().getText());

		desplegableCoches.selectByVisibleText("Tesla");
		assertEquals("Tesla", desplegableCoches.getFirstSelectedOption().getText());
	}

	@Ignore
	@Test
	public void testSelectMultiple() {
		driver.get("http://localhost:8080");

		WebElement desplegable = driver.findElement(By.id("colores"));
		Select desplegableColores = new Select(desplegable);

		assertTrue(desplegableColores.isMultiple());

		desplegableColores.selectByIndex(1);
		desplegableColores.selectByValue("black");

		assertEquals(2, desplegableColores.getAllSelectedOptions().size());

		desplegableColores.deselectByVisibleText("Black");
		assertEquals(1, desplegableColores.getAllSelectedOptions().size());

	}

	@Ignore
	@Test
	public void testRadios() {
		driver.get("http://localhost:8080");

		WebElement radio1 = driver.findElement(By.id("opcion1"));
		WebElement radio2 = driver.findElement(By.id("opcion2"));

		assertTrue(radio2.isSelected());
		assertFalse(radio1.isSelected());

		radio1.click();

		assertTrue(radio1.isSelected());
		assertFalse(radio2.isSelected());

	}

	@Ignore
	@Test
	public void testCheckBoxes() {
		driver.get("http://localhost:8080");

		WebElement check1 = driver.findElement(By.id("hobby1"));
		WebElement check4 = driver.findElement(By.id("hobby4"));

		assertTrue(check4.isSelected());
		assertFalse(check1.isSelected());

		check1.click();

		assertTrue(check4.isSelected());
		assertTrue(check1.isSelected());

	}

	@Ignore
	@Test
	public void labCheckBox()  {
		driver.get("https://todomvc.com/examples/vanillajs/");

		WebElement inputTareas = driver.findElement(By.cssSelector("input.new-todo"));

		for (int i = 0; i < 3; i++) {
			inputTareas.sendKeys("Tarea " + i);
			inputTareas.sendKeys(Keys.ENTER);
		}

		List<WebElement> listaCheckboxesTareas = driver.findElements(By.cssSelector("input[type='checkbox'].toggle"));

		assertEquals(3, listaCheckboxesTareas.size());
		assertFalse(listaCheckboxesTareas.get(0).isSelected());

		for (WebElement checkTarea : listaCheckboxesTareas) {
			if (!checkTarea.isSelected()) {
				checkTarea.click();
			}
			assertTrue(checkTarea.isSelected());
		}
		
		WebElement botonLimpiarCompletadas = driver.findElement(By.className("clear-completed"));
		botonLimpiarCompletadas.click();
		
		List<WebElement> listaTareas = driver.findElements(By.cssSelector("ul.todo-list > li"));
		assertEquals(0,  listaTareas.size());
	}
	
	@Ignore
	@Test
	public void testDobleClick() {
		driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
		
		WebElement caja = driver.findElement(By.id("message"));
		
		Actions builder = new Actions(driver);
		builder.doubleClick(caja).perform();
		
		assertEquals("rgba(255, 255, 0, 1)", caja.getCssValue("background-color"));
	}
	
	@Ignore
	@Test
	public void testDragAndDrop() {
		driver.get("http://cookbook.seleniumacademy.com/DragDropDemo.html");
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(draggable, droppable).perform();
		builder.clickAndHold(draggable).moveToElement(droppable).release().perform();
		
		assertEquals("Dropped!", droppable.getText());
	}
	
	@Ignore
	@Test
	public void testAlerts() {
		driver.get("http://localhost:8080");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("saludar()");
		
		driver.switchTo().alert().accept();
	}
	
	@Ignore
	@Test
	public void testScreenshot() throws InterruptedException, IOException {
		driver.get("https://resting.onrender.com");

		WebElement inputTitle = driver.findElement(By.tagName("input"));
		WebElement buttonStart = driver.findElement(By.className("css-i0fnhq"));
		inputTitle.sendKeys("Curso selenium");
		buttonStart.click();
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("src/test/resources/screenshots/cuenta-atras.png"));
		
		Thread.sleep(5000);
	}
	
	@Ignore
	@Test
	public void testCookies() {
		driver.get("http://localhost:8080");
		
		Cookie miCookie = new Cookie("miCookie", "Cookie que hemos creado");
		driver.manage().addCookie(miCookie);
		
		assertEquals(1, driver.manage().getCookies().size());
		assertEquals(miCookie, driver.manage().getCookieNamed("miCookie"));
		
		Cookie cookie = driver.manage().getCookieNamed("miCookie");
		assertEquals("Cookie que hemos creado", cookie.getValue());
	}

	
	@Test
	public void testEvents() {
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
		eventFiringWebDriver.register(new TraceListener());
		
		driver.get("http://localhost:8080");
		
		eventFiringWebDriver.findElement(By.id("no-existe"));
	}
}