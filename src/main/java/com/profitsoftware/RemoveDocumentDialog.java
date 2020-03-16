package com.profitsoftware;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class RemoveDocumentDialog extends Dialog {
  private Document document;

  public RemoveDocumentDialog(Document document, ComponentEventListener listener) {
    this.document = document;

    // Texts
    add(new Label("Vahvista poisto"));

    VerticalLayout texts = new VerticalLayout();

    texts.add(new Label("Haluatko varmasti poistaa tämän asiakirjan?"));

    add(texts);

    // Buttons
    HorizontalLayout buttons = new HorizontalLayout();
    buttons.setWidth("100%");

    Button deleteButton = new Button("Poista");
    deleteButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
    deleteButton.addClickListener(event -> close());
    deleteButton.addClickListener(listener);
    buttons.add(deleteButton);

    Button cancelButton = new Button("Peru");
    cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    cancelButton.addClickListener(event -> close());
    buttons.add(cancelButton);

    add(buttons);
  }
}
