package com.profitsoftware;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;


public class Header extends HorizontalLayout
{
  private Label logo;

  public Header()
  {
    logo = new Label("Varma");
    add(logo);
  }
}
