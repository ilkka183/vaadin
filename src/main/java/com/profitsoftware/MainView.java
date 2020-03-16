package com.profitsoftware;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout
{
  private Header header;
  private LoginView loginView;
  private ContentView contentView;

  private User user = null;
  private Users users = new Users();
  private Documents documents = new Documents();

  public MainView()
  {
    header = new Header();
    add(header);

    loginView = new LoginView();
    loginView.loginButton.addClickListener(event -> login());

    contentView = new ContentView();
    contentView.documentsLayout.logoutButton.addClickListener(event -> setUser(null));
    contentView.setDocuments(documents);
    contentView.setWidth("100%");

    setUser(users.get(0));
  }

  private void setUser(User user)
  {
    this.user = user;

    if (user != null)
    {
      remove(loginView);
      add(contentView);
    }
    else
    {
      contentView.closeDocument();

      add(loginView);
      remove(contentView);
    }
  }

  private void login()
  {
    String username = loginView.usernameField.getValue();
    String password = loginView.passwordField.getValue();

    if (username.isEmpty())
    {
      MessageDialog.show("Käyttäjänunnus puuttuu!");
      return;
    }

    if (password.isEmpty())
    {
      MessageDialog.show("Salasana puuttuu!");
      return;
    }

    User user = users.find(username);

    if ((user != null) && (user.getPassword().equals(password)))
    {
      loginView.clearFields();
      setUser(user);
    }
    else
      MessageDialog.show("Käyttäjänunnus tai salasana on virheellinen!");
  }
}
