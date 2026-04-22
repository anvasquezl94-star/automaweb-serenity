package org.autoweb.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.autoweb.ui.InventoryPage;

public class InventoryVisible implements Question<Boolean> {

    public static InventoryVisible isDisplayed() {
        return new InventoryVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return InventoryPage.TITLE.resolveFor(actor).isVisible() &&
               InventoryPage.TITLE.resolveFor(actor)
                       .getText().equals("Products");

    }
}