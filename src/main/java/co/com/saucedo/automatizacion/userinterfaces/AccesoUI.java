package co.com.saucedo.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccesoUI {

    private AccesoUI(){

    }

    public static final Target LBL_ERROR = Target.the("User Name Login").located(By.xpath("//h3[contains(.,'Username')]"));
    public static final Target LBL_PRODUCTOS = Target.the("User Name Login").located(By.xpath("//span[contains(.,'Prod')]"));
    public static final Target USER_FIELD = Target.the("User Name Login").located(By.id("user-name"));
    public static final Target PASSWORD_FIELD = Target.the("password Login").located(By.id("password"));
}
