package utilidades;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class LevantarDrives {

	MetodosGenericos mGenerico;

	public WebDriver driver;
	private WebDriverWait wait;
	private WebDriverWait wait2;
	private  DesiredCapabilities dc;
	//public AppiumDriver<MobileElement> driver;
	public String NombreImagen;
	public String [] NombreImage = new String[100];
	public String nombreBolsillo = "";

	
	public void cerrarAppiumDriver() {
		//driver.closeApp();
		driver.quit();	
	}
	
	public void iniciarChromeDriver() {
		System.setProperty("webdriver.chrome.driver", SystemEnvironmentVariables.createEnvironmentVariables().getProperty("webdriver.chrome.driver"));
		driver = new ChromeDriver();
		Serenity.setSessionVariable("driver").to(driver);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/watch?v=lnXpzOl19EY&t=1215s");

	}
	
	public void abrirWebRedeban() {
		iniciarChromeDriver();
		//chromeDriver.get(Credenciales.propertiesWebs().getProperty("web.redeban.url"));
		driver.manage().window().maximize();
		setWait(new WebDriverWait(driver, 60));
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}

	public WebDriverWait getWait2() {
		return wait2;
	}

	public void setWait2(WebDriverWait wait2) {
		this.wait2 = wait2;
	}
	
	
}
