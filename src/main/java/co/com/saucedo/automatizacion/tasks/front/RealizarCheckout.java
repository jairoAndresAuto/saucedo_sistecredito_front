package co.com.saucedo.automatizacion.tasks.front;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import java.util.Locale;
import static co.com.saucedo.automatizacion.userinterfaces.ArticulosUI.BTN_CHECKOUT;
import static co.com.saucedo.automatizacion.userinterfaces.ArticulosUI.BTN_CONTINUAR;
import static co.com.saucedo.automatizacion.userinterfaces.ArticulosUI.TXT_APELLIDO;
import static co.com.saucedo.automatizacion.userinterfaces.ArticulosUI.TXT_CODIGO;
import static co.com.saucedo.automatizacion.userinterfaces.ArticulosUI.TXT_NOMBRE;
import static co.com.saucedo.automatizacion.util.Constantes.ESPANIOL;
import static co.com.saucedo.automatizacion.util.Constantes.QUINIENTOS;

public class RealizarCheckout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker(new Locale(ESPANIOL));
        actor.attemptsTo(Click.on(BTN_CHECKOUT),
                Enter.theValue(faker.name().firstName()).into(TXT_NOMBRE),
                Enter.theValue(faker.name().lastName()).into(TXT_APELLIDO),
                Enter.theValue(String.valueOf(faker.random().nextInt(1111, 9999))).into(TXT_CODIGO),
                Click.on(BTN_CONTINUAR));
    }

    public static RealizarCheckout compra() {
        return Tasks.instrumented(RealizarCheckout.class);
    }
}
