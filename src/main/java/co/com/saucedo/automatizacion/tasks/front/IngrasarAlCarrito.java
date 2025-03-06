package co.com.saucedo.automatizacion.tasks.front;

import co.com.saucedo.automatizacion.questions.validarObjetos;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static co.com.saucedo.automatizacion.userinterfaces.ArticulosUI.*;
import static co.com.saucedo.automatizacion.util.Constantes.ESPANIOL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class IngrasarAlCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker(new Locale(ESPANIOL));
        actor.attemptsTo(Click.on(BTN_CARRITO));
        List<String> nombres = LBL_NOMBRES_COMPRA.resolveAllFor(actor).texts();
        List<String> precios = LBL_PRECIO_COMPRA.resolveAllFor(actor).texts();
        Collections.sort(nombres);
        Collections.sort(precios);
        actor.should(seeThat(validarObjetos.aComparar(nombres.toString(), actor.recall("nombresEscogidos").toString())));
        actor.should(seeThat(validarObjetos.aComparar(precios.toString(), actor.recall("preciosEscogidos").toString())));
        actor.should();
    }

    public static IngrasarAlCarrito deArticulo() {
        return Tasks.instrumented(IngrasarAlCarrito.class);
    }
}
