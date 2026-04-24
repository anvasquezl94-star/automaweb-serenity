package org.autoweb.steps;


import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import org.autoweb.questions.InventoryVisible;
import org.autoweb.questions.MyCartVisible;
import org.autoweb.tasks.AddProduct;
import org.autoweb.tasks.Cart;
import org.autoweb.tasks.Login;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AddToCartSteps {



    @Given("que el usuario ha iniciado sesión")
    public void que_el_usuario_ha_iniciado_sesion() {
        /*
        String url = System.getenv("BASE_URL");
        String username = System.getenv("USER_USERNAME");
        String password = System.getenv("USER_PASSWORD");
        OnStage.theActorCalled("Usuario").attemptsTo(
               // Open.url(baseUrl),
                AbrirPagina.en(url),
                Login.withCredentials(username, password)
        );*/
        // Llamar a los métodos de LoginSteps
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.abrirWeb();        // Abre la página
        loginSteps.ingresaCredenciales();  // Hace login
    }

    @When("agrega {string} al carrito")
    public void agrega_al_carrito(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProduct.toCart(productName)  // ← Llama al Task
        );
        System.out.println("Agrega al carrito: " + productName);
    }

    @And("va al carrito de compras")
    public void va_al_carrito_de_compras() {
        // Aquí puedes agregar la acción para ir al carrito más tarde
        OnStage.theActorInTheSpotlight().attemptsTo(
                Cart.goCart()
        );
        System.out.println("Va al carrito de compras ");
    }

    @Then ("debería ver el carrito")
    public void deberia_ver_el_producto_en_el_carrito() {
        // Aquí puedes agregar la validación más tarde
        OnStage.theActorInTheSpotlight().should(
                seeThat(MyCartVisible.isDisplayed())
        );
        System.out.println("debería ver el carrito ");
    }

}