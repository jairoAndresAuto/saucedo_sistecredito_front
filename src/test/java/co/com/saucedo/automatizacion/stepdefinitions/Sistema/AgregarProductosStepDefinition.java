package co.com.saucedo.automatizacion.stepdefinitions.Sistema;

import co.com.saucedo.automatizacion.questions.ValidarMensaje;
import co.com.saucedo.automatizacion.questions.ValidarSubTotal;
import co.com.saucedo.automatizacion.questions.ValidarTotal;
import co.com.saucedo.automatizacion.tasks.front.IngrasarAlCarrito;
import co.com.saucedo.automatizacion.tasks.front.OrganizarYEscoger;
import co.com.saucedo.automatizacion.tasks.front.RealizarCheckout;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgregarProductosStepDefinition {


    @Cuando("Se procede a organizar los elementos, los agrega al carrito")
    public void seProcedeAOrganizarLosElementosLosAgregaAlCarrito() {
        theActorInTheSpotlight().attemptsTo(OrganizarYEscoger.articulos());
    }

    @Cuando("ingresa a la lista de agregados")
    public void ingresaALaListaDeAgregados() {
        theActorInTheSpotlight().attemptsTo(IngrasarAlCarrito.deArticulo());
    }

    @Y("realiza el checkout")
    public void realizaElCheckout() {
        theActorInTheSpotlight().attemptsTo(RealizarCheckout.compra());
    }

    @Entonces("valida que la informacion este congruente")
    public void validaQueLaInformacionEsteCongruente() {
        theActorInTheSpotlight().should(
                seeThat(ValidarSubTotal.precio()),
                seeThat(ValidarTotal.precio()),
                seeThat(ValidarMensaje.deExito()));
    }

}
