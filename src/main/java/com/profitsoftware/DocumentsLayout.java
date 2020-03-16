package com.profitsoftware;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class DocumentsLayout extends VerticalLayout {
  public Button logoutButton;
  public Grid<Document> grid;

  public DocumentsLayout() {
    logoutButton = new Button("Kirjaudu ulos");
    logoutButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    add(logoutButton);

    grid = new Grid<Document>(Document.class);
    grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
    grid.setColumns("name", "code", "personalNumber", "businessId", "createdTime", "modifiedTime");
    add(grid);
  }
}
