package com.profitsoftware;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.button.Button;


public class DocumentDialog extends Dialog {
  private Document document;
  private VerticalLayout components;
  private HorizontalLayout buttons;

  public DocumentDialog(Document document, String title)
  {
    this.document = document;

    add(new Label(title));

    components = new VerticalLayout();
    components.setWidth("100%");
    add(components);

    buttons = new HorizontalLayout();
    buttons.setWidth("100%");
    add(buttons);
  }

  protected void addComponent(Component component)
  {
    components.add(component);
  }

  protected void addButton(Button button)
  {
    buttons.add(button);
  }
}
