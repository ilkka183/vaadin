package com.profitsoftware;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;


public class LoginView extends VerticalLayout
{
  public TextField usernameField;
  public PasswordField passwordField;
  public Button loginButton;
  public Button testButton;

  public LoginView()
  {
    usernameField = new TextField("Käyttäjätunnus");
    add(usernameField);

    passwordField = new PasswordField("Salasana");
    add(passwordField);

    // Buttons
    HorizontalLayout buttons = new HorizontalLayout();

    loginButton = new Button("Kirjaudu sisään");
    loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    buttons.add(loginButton);

    testButton = new Button("Testikäyttäjä");
    testButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    testButton.addClickListener(event -> fillTestValues());
    buttons.add(testButton);

    add(buttons);
  }

  public void clearFields()
  {
    usernameField.clear();
    passwordField.clear();
  }

  private void fillTestValues()
  {
    usernameField.setValue("ilkka");
    passwordField.setValue("huuhaa");
  }
}
