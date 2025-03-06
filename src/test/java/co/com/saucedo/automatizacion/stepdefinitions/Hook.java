package co.com.saucedo.automatizacion.stepdefinitions;

import co.com.saucedo.automatizacion.tasks.front.RealizarInicio;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static co.com.saucedo.automatizacion.util.Constantes.ARCHIVO_PROPERTIES;
import static co.com.saucedo.automatizacion.util.Constantes.BASE_URL_FRONT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {

    private static Properties propiedades = new Properties();

    @Managed(driver = "chrome")
    public static WebDriver driver;

    @Before
    public static void setTheStage() throws IOException {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("Calidad");
        FileInputStream archivo = new FileInputStream(ARCHIVO_PROPERTIES);
        propiedades.load(archivo);
    }

    @Dado("Procede a abrir la url")
    public void procedeAAbrirLaUrl() {
        String baseUrlFront = propiedades.getProperty(BASE_URL_FRONT);
        theActorInTheSpotlight().can(BrowseTheWeb.with(driver)).
                attemptsTo(Open.url(baseUrlFront));
    }

    @Dado("que el usuario procede a loguearse")
    public void queElUsuarioProcedeALoguearse() {
        String usuario = propiedades.getProperty("usuario.front");
        String password = propiedades.getProperty("password.front");
        theActorInTheSpotlight().attemptsTo(RealizarInicio.sesion(usuario,password));
    }
}
