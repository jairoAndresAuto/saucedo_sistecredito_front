package co.com.saucedo.automatizacion.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


@AllArgsConstructor
public class ValidarContains implements Question<Boolean> {

    private String obtenido;
    private String esperado;

    @Override
    public Boolean answeredBy(Actor actor) {
        return obtenido.contains(esperado);
    }

    public static ValidarContains string(String obtenido, String esperado) {
        return new ValidarContains(obtenido,esperado);
    }
}
