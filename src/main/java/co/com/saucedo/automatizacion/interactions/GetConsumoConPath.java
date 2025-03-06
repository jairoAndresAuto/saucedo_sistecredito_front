package co.com.saucedo.automatizacion.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static co.com.saucedo.automatizacion.util.Constantes.APPLICATIONJSON;
import static co.com.saucedo.automatizacion.util.Constantes.ETIQUETA_APPLICATIONJSON;

@AllArgsConstructor
public class GetConsumoConPath extends RestInteraction {

    private String idBooking;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(String.valueOf(idBooking))
                .with(request -> request
                        .relaxedHTTPSValidation()
                        .header(ETIQUETA_APPLICATIONJSON, APPLICATIONJSON)));
    }

    public static GetConsumoConPath servicio(String idBooking) {
        return new GetConsumoConPath(idBooking);
    }
}
