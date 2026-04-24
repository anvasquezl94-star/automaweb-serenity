package org.autoweb.steps;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.Stage;
import org.autoweb.tasks.AbrirPagina;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.Serenity;
import org.autoweb.tasks.Login;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import org.autoweb.questions.InventoryVisible;

public class LoginSteps {

    @Given("que el usuario abre la página de Sauce")
    public void abrirWeb() {

        System.out.println("Cuando el usuario abre la página de Sauce");
        // Inicializar el escenario
        OnStage.setTheStage(Cast.ofStandardActors());  // ← Cambia aquí
        var driver = Serenity.getDriver();
        driver.manage().window().maximize();


        // Crear el actor y darle la habilidad de navegar
        OnStage.theActorCalled("Usuario").can(BrowseTheWeb.with(driver));

        String url = System.getenv("BASE_URL");
        OnStage.theActorInTheSpotlight().attemptsTo(
                AbrirPagina.en(url)
        );
    }

    @When("ingresa sus credenciales válidas")
    public void ingresaCredenciales() {
        String username = System.getenv("USER_USERNAME");
        String password = System.getenv("USER_PASSWORD");

        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(username, password)
        );
    }

    @Then("debería ver el inventario de productos")
    public void validaInventario() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(InventoryVisible.isDisplayed())
        );
    }

}