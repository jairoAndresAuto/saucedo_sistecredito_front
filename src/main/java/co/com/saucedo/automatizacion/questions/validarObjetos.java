package co.com.saucedo.automatizacion.questions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@EqualsAndHashCode
@AllArgsConstructor
public class validarObjetos implements Question<Boolean> {

    private Object obtenido;
    private Object esperado;

    @Override
    public Boolean answeredBy(Actor actor) {
        return obtenido.equals(esperado);
    }

    public static validarObjetos aComparar(Object obtenido,Object esperado) {
        return new validarObjetos(obtenido,esperado);
    }
}
