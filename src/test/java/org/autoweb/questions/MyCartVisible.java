package org.autoweb.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
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
}