package org.autoweb.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GoCartPage {

    //localiza el botón para ir al carrito
    public static final Target CARRITO = Target.the("icono carrito")
            .located(By.id("shopping_cart_container"));
}