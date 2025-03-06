package co.com.saucedo.automatizacion.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;
import static co.com.saucedo.automatizacion.util.Constantes.APPLICATIONJSON;
import static co.com.saucedo.automatizacion.util.Constantes.ETIQUETA_APPLICATIONJSON;

@AllArgsConstructor
public class PostConsumirServicioSinPath implements Interaction {

    private String json;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("")
                .with(request -> request
                        .relaxedHTTPSValidation()
                        .header(ETIQUETA_APPLICATIONJSON, APPLICATIONJSON)
                        .body(json)));
    }

    public static PostConsumirServicioSinPath servicio(String json) {
        return new PostConsumirServicioSinPath(json);
    }

}
