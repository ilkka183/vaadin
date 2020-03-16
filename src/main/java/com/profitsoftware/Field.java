package com.profitsoftware;

public class Field {
  private String name;
  private String value;

  public Field(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }
  public void setName(String value) {
    name = value;
  }

  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }

}
