package com.profitsoftware;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;


public class MessageDialog extends Dialog
{
  public MessageDialog(String text)
  {
    add(new Label(text));

    HorizontalLayout buttons = new HorizontalLayout();
    buttons.setWidth("100%");

    Button okButton = new Button("OK");
    okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    okButton.addClickListener(event -> close());
    buttons.add(okButton);

    add(buttons);
  }

  public static void show(String text)
  {
    MessageDialog dialog = new MessageDialog(text);
    dialog.open();
  }
}
