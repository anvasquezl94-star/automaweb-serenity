package org.autoweb.steps;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.autoweb.tasks.AbrirPagina;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.Serenity;
public class LoginSteps {
    //private WebDriver driver;
    Actor usuario = Actor.named("Usuario");

   /* public LoginSteps(WebDriver driver){
        this.driver = driver;
    }*/

    @Given("que el usuario abre la web")
    public void abrirWeb() {

        System.out.println("INICIANDO AUTOMATIZACIÓN WEB...");
        var driver = Serenity.getDriver();

        driver.manage().window().maximize();
        usuario.can(BrowseTheWeb.with(driver));
        String url = System.getenv("BASE_URL");
        usuario.attemptsTo(
                AbrirPagina.en(url)
        );
    }
}