package co.com.saucedo.automatizacion.stepdefinitions.Sistema;

import co.com.saucedo.automatizacion.questions.Validar;
import co.com.saucedo.automatizacion.questions.ValidarContains;
import co.com.saucedo.automatizacion.questions.ValidarMensaje;
import co.com.saucedo.automatizacion.tasks.front.RealizarInicio;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;
import java.util.Map;

import static co.com.saucedo.automatizacion.userinterfaces.AccesoUI.LBL_ERROR;
import static co.com.saucedo.automatizacion.userinterfaces.AccesoUI.LBL_PRODUCTOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class loginStepDefinition {

    @Cuando("que el usuario procede a con otros datos")
    public void queElUsuarioProcedeAConOtrosDatos(List<Map<String,String>> credenciales) {
        theActorInTheSpotlight().attemptsTo(RealizarInicio.
                sesion(credenciales.get(0).get("user"),
                        credenciales.get(0).get("clave")));
    }

    @Entonces("Valida que se logue de forma exitosa")
    public void validaQueSeLogueDeFormaExitosa() {
      theActorInTheSpotlight().should(seeThat(Validar.
              string(LBL_PRODUCTOS.resolveFor(theActorInTheSpotlight()).getText()
                      ,"Products")));
    }

    @Entonces("Valida que salga un error en el sistema")
    public void validaQueSalgaUnErrorEnElSistema() {
        theActorInTheSpotlight().should(seeThat(ValidarContains.
                string(LBL_ERROR.resolveFor(theActorInTheSpotlight()).getText()
                        ,"Username and password do not match any user in this service")));
    }
}
