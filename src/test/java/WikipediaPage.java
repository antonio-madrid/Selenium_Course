import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPage {

	private WebDriver driver;
	public static String URL = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
	
	@FindBy(id = "searchInput")
	private WebElement inputBuscar;
	
	@FindBy(id = "searchButton")
	private WebElement buttonBuscar;


	public WikipediaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void buscar(String texto) {
		inputBuscar.clear();
		inputBuscar.sendKeys(texto);
		buttonBuscar.click();
	}

}
