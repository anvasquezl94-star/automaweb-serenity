package org.autoweb.ui;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;


public class InventoryPage {
    public static final Target TITLE = Target.the("título de inventario")
            .locatedBy(".title");

    public static Target ADD_TO_CART_BUTTON(String productName) {
        String formattedName = productName.toLowerCase().replace(" ", "-");

        return Target.the("Add to cart button for " + productName)
                .located(By.id("add-to-cart-" + formattedName));
    }

}