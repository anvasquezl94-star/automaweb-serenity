package org.autoweb.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERNAME = Target.the("campo username")
            .located(By.id("user-name"));

    public static final Target PASSWORD = Target.the("campo password")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("botón login")
            .located(By.id("login-button"));
}