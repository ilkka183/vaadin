package com.profitsoftware;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;


public class LoginLayout extends VerticalLayout {
  public TextField usernameField;
  public PasswordField passwordField;
  public Button loginButton;

  public LoginLayout() {
    usernameField = new TextField("Käyttäjätunnus");
    usernameField.setValue("ilkka");

    passwordField = new PasswordField("Salasana");
    passwordField.setValue("huuhaa");

    loginButton = new Button("Kirjaudu sisään");
    loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

    add(usernameField);
    add(passwordField);
    add(loginButton);
  }
}
