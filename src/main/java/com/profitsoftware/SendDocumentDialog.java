package com.profitsoftware;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;


public class SendDocumentDialog extends DocumentDialog
{
  public SendDocumentDialog(Document document)
  {
    super(document, "Vahvista asiakirjan lähetys");

    addComponent(new Label("Lähetetäänkö asiakirja " + document.getCode() + "?"));
    addComponent(new Checkbox("Arkistoon", true));
    addComponent(new Checkbox("Keskitettyyn tulostukseen", true));

    Button sendButton = new Button("Lähetä");
    sendButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
    sendButton.addClickListener(event -> close());
    addButton(sendButton);

    Button cancelButton = new Button("Peru");
    cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    cancelButton.addClickListener(event -> close());
    addButton(cancelButton);
  }
}
