package org.autoweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.autoweb.ui.GoCartPage;

public class Cart implements Task {



    public static Cart goCart() {
        return Tasks.instrumented(Cart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(GoCartPage.CARRITO)
        );
    }
}