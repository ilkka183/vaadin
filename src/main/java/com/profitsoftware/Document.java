package com.profitsoftware;

import java.util.Date;

public class Document {
  private String id;
  private String name;
  private String code;
  private String personalNumber;
  private String businessId;
  private Date createdTime = new Date();
  private Date modifiedTime = null;

  public Document(String id, String name, String code, String personalNumber, String businessId) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.personalNumber = personalNumber;
    this.businessId = businessId;
  }

  public String getId() {
    return id;
  }
  public void setId(String value) {
    id = value;
  }

  public String getName() {
    return name;
  }
  public void setName(String value) {
    name = value;
  }

  public String getCode() {
    return code;
  }
  public void setCode(String value) {
    code = value;
  }

  public String getPersonalNumber() {
    return personalNumber;
  }
  public void setPersonalNumber(String value) {
    personalNumber = value;
  }

  public String getBusinessId() {
    return businessId;
  }
  public void setBusinessID(String value) {
    businessId = value;
  }

  public Date getCreatedTime() {
    return createdTime;
  }
  public void setCreatedTime(Date value) {
    createdTime = value;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }
  public void setModifiedTime(Date value) {
    modifiedTime = value;
  }

  public String toString() {
    return id + ", " + name + ", " + code;
  }
}
