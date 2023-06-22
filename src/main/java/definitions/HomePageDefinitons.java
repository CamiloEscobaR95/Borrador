package definitions;

import cucumber.api.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import pages.HomePageUI;
import utilidades.MetodosGenericos;

public class HomePageDefinitons {

    MetodosGenericos mt = new MetodosGenericos();

    HomePageUI homePageObj = new HomePageUI();

    @Given("^el usuario ingresa a youtube$")
    public void elUsuarioIngresaAYoutube() {
        HomePageUI youtube = new HomePageUI();
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Open.browserOn(youtube)

        );
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HomePageUI.clickBtn();

    }


    @When("^el usuario realiza la busqueda de un tema UB(\\d+) - Kingston Town$")
    public void elUsuarioRealizaLaBusquedaDeUnTemaUBKingstonTown(int arg1) {
        mt.tomaEvidenciaPC("detalle");
    }

    @Then("^el usuario visulaiza los diferentes resultados de busqueda UB(\\d+) - Kingston Town$")
    public void elUsuarioVisulaizaLosDiferentesResultadosDeBusquedaUBKingstonTown(int arg1) {

    }


}
