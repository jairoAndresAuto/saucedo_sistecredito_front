package co.com.saucedo.automatizacion.util;

import java.util.Base64;

public class Utilidades {

    private Utilidades() {
    }

    public static String validarDato(String dato) {
        return (dato != null) ? dato : "";
    }
}
