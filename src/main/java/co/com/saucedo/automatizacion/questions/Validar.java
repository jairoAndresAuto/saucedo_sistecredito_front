package co.com.saucedo.automatizacion.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


@AllArgsConstructor
public class Validar implements Question<Boolean> {

    private String obtenido;
    private String esperado;

    @Override
    public Boolean answeredBy(Actor actor) {
        return obtenido.equals(esperado);
    }

    public static Validar string(String obtenido,String esperado) {
        return new Validar(obtenido,esperado);
    }
}
