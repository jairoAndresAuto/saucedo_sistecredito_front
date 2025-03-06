package co.com.saucedo.automatizacion.tasks.front;


import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static co.com.saucedo.automatizacion.userinterfaces.ArticulosUI.*;
import static co.com.saucedo.automatizacion.util.Constantes.ESPANIOL;


public class OrganizarYEscoger implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker(new Locale(ESPANIOL));
        int cantidadUno = BTN_ADD_CART.resolveAllFor(actor).size() - 1;
        BTN_ADD_CART.resolveAllFor(actor).get(faker.random().nextInt(0, cantidadUno)).click();
        int cantidadDos = BTN_ADD_CART.resolveAllFor(actor).size() - 1;
        BTN_ADD_CART.resolveAllFor(actor).get(faker.random().nextInt(0, cantidadDos)).click();
        List<String> nombres = LBL_NOMBRES.resolveAllFor(actor).texts();
        List<String> precios =LBL_PRECIO.resolveAllFor(actor).texts();
        Collections.sort(nombres);
        Collections.sort(precios);
        actor.remember("nombresEscogidos", nombres);
        actor.remember("preciosEscogidos", precios);
    }

    public static OrganizarYEscoger articulos() {
        return Tasks.instrumented(OrganizarYEscoger.class);
    }
}
