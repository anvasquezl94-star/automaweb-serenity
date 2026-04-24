package org.autoweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.autoweb.ui.InventoryPage;

public class AddProduct implements Task {

    private final String productName;

    public AddProduct(String productName) {
        this.productName = productName;
    }

    public static AddProduct toCart(String productName) {
        return Tasks.instrumented(AddProduct.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.ADD_TO_CART_BUTTON(productName))
        );
    }
}
