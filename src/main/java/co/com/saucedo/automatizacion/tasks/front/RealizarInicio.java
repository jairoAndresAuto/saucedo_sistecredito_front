package co.com.saucedo.automatizacion.tasks.front;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;

import static co.com.saucedo.automatizacion.userinterfaces.AccesoUI.PASSWORD_FIELD;
import static co.com.saucedo.automatizacion.userinterfaces.AccesoUI.USER_FIELD;
import static co.com.saucedo.automatizacion.util.Constantes.LOGIN;
import static co.com.saucedo.automatizacion.util.Utilidades.codificacionBase64;

@AllArgsConstructor
public class RealizarInicio implements Task {

    private String user;
    private String pass;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(USER_FIELD),
                Enter.theValue(pass).into(PASSWORD_FIELD),
                Click.on(Button.withText(LOGIN))
        );
    }

    public static RealizarInicio sesion(String user, String pass) {
        return Tasks.instrumented(RealizarInicio.class, user, pass);
    }

}
