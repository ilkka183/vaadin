package com.profitsoftware;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;


@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout
{
  private Header header;
  private LoginLayout loginLayout;
  private MainLayout mainLayout;

  private User user = null;
  private List<User> users = new ArrayList<>();
  private List<Document> documents = new ArrayList<>();

  public MainView()
  {
    users.add(new User("ilkka", "huuhaa", "Ilkka", "Salmenius"));
    users.add(new User("antti", "huuhaa", "Antti", "Laurila"));
    users.add(new User("teppo", "huuhaa", "Teppo", "Testaaja"));

    documents.add(new Document("1", "Ilkka Salmenius", "ABC", "010101-XXXX", ""));
    documents.add(new Document("2", "Antti Laurila", "123", "010201-XXXX", "3-1234567"));
    documents.add(new Document("3", "Teppo Testaaja", "XYZ", "010301-XXXX", ""));
    documents.add(new Document("3", "Matti meikäläinen", "KLM", "010301-yyyy", ""));

    header = new Header();

    loginLayout = new LoginLayout();
    loginLayout.loginButton.addClickListener(event -> login());

    mainLayout = new MainLayout();
    mainLayout.documentsLayout.logoutButton.addClickListener(event -> setUser(null));
    mainLayout.setDocuments(documents);

    setUser(users.get(0));
  }

  private void showMessage(String text) {
    MessageDialog dialog = new MessageDialog(text);
    dialog.open();
  }

  private User findUser(String username)
  {
    for (User user : users)
      if (user.getUsername().equals(username))
        return user;

    return null;
  }

  private void setUser(User user) {
    if (user != null) {
      this.user = user;

//    usernameField.clear();
//    passwordField.clear();

      remove(loginLayout);
      add(mainLayout);
    } else {
      user = null;

      remove(mainLayout);
      add(loginLayout);
    }
  }

  private void login()
  {
    String username = loginLayout.usernameField.getValue();
    String password = loginLayout.passwordField.getValue();

    if (username.isEmpty() || password.isEmpty()) {
      showMessage("Käyttäjänunnus ja salasana vaaditaan!");
      return;
    }

    User user = findUser(username);

    if ((user != null) && (user.getPassword().equals(password)))
      setUser(user);
    else
      showMessage("Käyttäjänunnus tai salasana on virheellinen!");
  }

  private void showPreview() {
    showMessage("Preview");
  }

  private void showMeta() {
    showMessage("Meta");
  }
}
