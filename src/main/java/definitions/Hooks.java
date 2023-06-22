package definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilidades.Cronometro;
import utilidades.Evidencias;
import utilidades.LevantarDrives;
import utilidades.MetodosGenericos;

import java.io.File;

public class Hooks {
    LevantarDrives levantarDriver = new LevantarDrives();
    MetodosGenericos mt = new MetodosGenericos();
    Cronometro cronometro = new Cronometro();
    Evidencias evidencias = new Evidencias();

    WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {

        System.out.println("Inicio Test");
        levantarDriver.iniciarChromeDriver();
        cronometro.iniciarCronometro();
        System.setProperty("RutaEvidencias", System.getProperty("user.dir") + File.separator + "Evidencias" + File.separator + scenario.getName().split("_")[0]);
        new File(System.getProperty("user.dir") + File.separator + "Evidencias" + File.separator + scenario.getName().split("_")[0]).mkdirs();
        evidencias.eliminarImagenes(System.getProperty("RutaEvidencias"));



        /*OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Camilo");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        Serenity.setSessionVariable("driver").to(driver);*/

        /*switch (SystemEnvironmentVariables.createEnvironmentVariables().getProperty("webdriver.driver")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriverManager();

                break;
        }*/
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            mt.tomaEvidenciaPC("Se presento un error");
        }

        try {
            String tiempoPrueba = cronometro.pararCronometro();
            evidencias.generarReporte(System.getProperty("RutaEvidencias"), scenario.getName(), scenario.getStatus().toString(),tiempoPrueba);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Evidencias.numeroScreen = 1;
    }


}

