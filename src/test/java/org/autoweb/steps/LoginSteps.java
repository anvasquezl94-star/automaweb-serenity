package org.autoweb.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.autoweb.tasks.AbrirPagina;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.Serenity;
import org.autoweb.tasks.Login;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import org.autoweb.questions.InventoryVisible;
public class LoginSteps {
    //private WebDriver driver;
    Actor usuario = Actor.named("Usuario");

   /* public LoginSteps(WebDriver driver){
        this.driver = driver;
    }*/

    @Given("que el usuario abre la página de Sauce")
    public void abrirWeb() {

        System.out.println("INICIANDO AUTO WEB...");
        System.out.println("AUTO WEB sauce compras onlinegit");
        var driver = Serenity.getDriver();

        driver.manage().window().maximize();
        usuario.can(BrowseTheWeb.with(driver));
        String url = System.getenv("BASE_URL");
        usuario.attemptsTo(
                AbrirPagina.en(url)
        );
    }

    @When("ingresa sus credenciales válidas")
    public void ingresaCredenciales() {
        String username = System.getenv("USER_USERNAME");
        String password = System.getenv("USER_PASSWORD");

        usuario.attemptsTo(
                Login.withCredentials(username, password)
        );
    }

    @Then("debería ver el inventario de productos")
    public void validaInventario() {
        usuario.should(
                seeThat(InventoryVisible.isDisplayed())
        );
    }

}