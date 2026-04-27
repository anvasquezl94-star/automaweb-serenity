package org.autoweb.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MyCartPage {
    public static final Target TITLE_MYCART = Target.the("título de carrito")
            .locatedBy(".title");

    // Nuevo Target para la lista de productos en el carrito
    public static final Target CART_ITEMS = Target.the("lista de productos en el carrito")
            .locatedBy(".cart_item");  // Selector para cada item del carrito (puedes usar ".inventory_item" si es más específico)

    }


