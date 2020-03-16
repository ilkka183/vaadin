package com.profitsoftware;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;


public class DocumentLayout extends VerticalLayout {
  public HorizontalLayout buttonsLayout;
  public Button editButton;
  public Button sendButton;
  public Button removeButton;
  public Button closeButton;
  public HorizontalLayout tabsLayout;
  public Tab previewTab;
  public Tab metaTab;
  public Tabs tabs;
  public TextArea preview;
  public Grid<Field> fieldsGrid;

  public DocumentLayout() {
    setWidth("40%");

    buttonsLayout = new HorizontalLayout();
    buttonsLayout.setWidth("100%");

    editButton = new Button("Muokkaa");
    editButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    buttonsLayout.add(editButton);

    sendButton = new Button("Lähetä");
    sendButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    buttonsLayout.add(sendButton);

    removeButton = new Button("Poista");
    removeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    buttonsLayout.add(removeButton);

    closeButton = new Button("Sulje");
    closeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    buttonsLayout.add(closeButton);

    add(buttonsLayout);


    previewTab = new Tab("Esikatselu");
    metaTab = new Tab("Metatiedot");
    tabs = new Tabs(previewTab, metaTab);
    tabs.addSelectedChangeListener(event -> tabSelected(event.getSelectedTab()));

    add(tabs);

    preview = new TextArea();
    preview.setWidth("100%");
    preview.setHeight("400px");

    fieldsGrid = new Grid<Field>(Field.class);
    fieldsGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);

    for (Grid.Column column : fieldsGrid.getColumns())
      column.setSortable(false);

    add(preview);
//    add(fieldsGrid);
  }

  private void tabSelected(Tab tab) {
    if (tab == previewTab) {
      remove(fieldsGrid);
      add(preview);
    }
    else if (tab == metaTab) {
      remove(preview);
      add(fieldsGrid);
    }
  }
}
