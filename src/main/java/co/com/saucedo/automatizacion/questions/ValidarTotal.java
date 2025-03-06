package co.com.saucedo.automatizacion.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.saucedo.automatizacion.userinterfaces.ArticulosUI.LBL_PRECIO_IMPUESTO;
import static co.com.saucedo.automatizacion.userinterfaces.ArticulosUI.LBL_PRECIO_TOTAL;

public class ValidarTotal implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        double subTotal = Double.valueOf(actor.recall("subtotal").toString());
        double impuesto = Double.valueOf(LBL_PRECIO_IMPUESTO.resolveFor(actor).getText().replace("Tax: $", ""));
        double total = subTotal + impuesto;
        Serenity.recordReportData().withTitle("total").andContents(LBL_PRECIO_TOTAL.resolveFor(actor).getText().replace("Total: $",""));
        Serenity.recordReportData().withTitle("total").andContents(String.valueOf(total));
        return String.format("%.2f",Double.valueOf(LBL_PRECIO_TOTAL.resolveFor(actor).getText().replace("Total: $",""))).equals( String.format("%.2f",total));
    }

    public static ValidarTotal precio() {
        return new ValidarTotal();
    }
}
