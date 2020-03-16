package com.profitsoftware;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Label;


public class RemoveDocumentDialog extends DocumentDialog
{
  public RemoveDocumentDialog(Document document, ComponentEventListener listener)
  {
    super(document, "Vahvista asiakirjan poisto");

    addComponent(new Label("Haluatko varmasti poistaa asiakirjan " + document.getCode() + "?"));

    Button deleteButton = new Button("Poista");
    deleteButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
    deleteButton.addClickListener(event -> close());
    deleteButton.addClickListener(listener);
    addButton(deleteButton);

    Button cancelButton = new Button("Peru");
    cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    cancelButton.addClickListener(event -> close());
    addButton(cancelButton);
  }
}
