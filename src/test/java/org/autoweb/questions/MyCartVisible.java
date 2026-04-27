package org.autoweb.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.autoweb.ui.InventoryPage;
import org.autoweb.ui.MyCartPage;

public class MyCartVisible implements Question<Boolean> {

    public static MyCartVisible isDisplayed() {
        return new MyCartVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return MyCartPage.TITLE_MYCART.resolveFor(actor).isVisible() &&
                MyCartPage.TITLE_MYCART.resolveFor(actor)
                        .getText().equals("Your Cart");

    }
    // Nueva Question para validar que hay al menos un producto en el carrito
    public static Question<Boolean> atLeastOneProductInCart() {
        return actor -> {
            // Obtiene la lista de elementos y verifica si hay al menos uno
            return !BrowseTheWeb.as(actor).findAll(MyCartPage.CART_ITEMS).isEmpty();
        };
    }
}