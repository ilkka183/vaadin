package com.profitsoftware;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class SendDocumentDialog extends Dialog {
  private Document document;

  public SendDocumentDialog(Document document) {
    this.document = document;

    add(new Label("Haluatko varmasti lähettää tämän asiakirjan?"));

    VerticalLayout layout = new VerticalLayout();
    layout.add(new Checkbox("Lähetetäänkö asiakirja arkistoon?", true));
    layout.add(new Checkbox("Lähetetäänkö asiakirja keskitettyyn tulostukseen?", true));
    add(layout);

    HorizontalLayout buttons = new HorizontalLayout();
    buttons.setWidth("100%");

    Button sendButton = new Button("Lähetä");
    sendButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
    sendButton.addClickListener(event -> close());
    buttons.add(sendButton);

    Button cancelButton = new Button("Peru");
    cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    cancelButton.addClickListener(event -> close());
    buttons.add(cancelButton);

    add(buttons);
  }
}
