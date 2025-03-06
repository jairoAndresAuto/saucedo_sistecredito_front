package co.com.saucedo.automatizacion.util;

import co.com.saucedo.automatizacion.tasks.ficheros.LeerFicheroSin;
import net.serenitybdd.screenplay.Actor;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static co.com.saucedo.automatizacion.util.Constantes.RUTA_DATOS_PRECIOS;

public class Utilidades {

    private Utilidades() {
    }

    public static String codificacionBase64(String clave) {
        byte[] decodedBytes = Base64.getDecoder().decode(clave);
        return new String(decodedBytes);
    }

    public static List<Double> ordenarDescendentemente(List<Double> lista, Actor actor,String tipoOrdenamiento) {
        actor.attemptsTo(LeerFicheroSin.sobreEscribirDatos(RUTA_DATOS_PRECIOS,
                lista.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).toString(),tipoOrdenamiento));
        return lista.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public static List<Double> ordenarAscendentemente(List<Double> lista, Actor actor,String tipoOrdenamiento) {
        actor.attemptsTo(LeerFicheroSin.sobreEscribirDatos(RUTA_DATOS_PRECIOS,
                lista.stream().sorted().collect(Collectors.toList()).toString(),tipoOrdenamiento));
        return lista.stream().sorted().collect(Collectors.toList());
    }

    public static String validarDato(String dato) {
        return (dato != null) ? dato : "";
    }
}
