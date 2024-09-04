package com.engagehub.api.codegen.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Business {
  private String id;

  private String name;

  private String address;

  private String type;

  private String contactInformation;

  public Business() {
  }

  public Business(String id, String name, String address, String type, String contactInformation) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.type = type;
    this.contactInformation = contactInformation;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getContactInformation() {
    return contactInformation;
  }

  public void setContactInformation(String contactInformation) {
    this.contactInformation = contactInformation;
  }

  @Override
  public String toString() {
    return "Business{" + "id='" + id + "'," +"name='" + name + "'," +"address='" + address + "'," +"type='" + type + "'," +"contactInformation='" + contactInformation + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Business that = (Business) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(address, that.address) &&
                            java.util.Objects.equals(type, that.type) &&
                            java.util.Objects.equals(contactInformation, that.contactInformation);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, name, address, type, contactInformation);
  }

  public static com.engagehub.api.codegen.types.Business.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String name;

    private String address;

    private String type;

    private String contactInformation;

    public Business build() {
                  com.engagehub.api.codegen.types.Business result = new com.engagehub.api.codegen.types.Business();
                      result.id = this.id;
          result.name = this.name;
          result.address = this.address;
          result.type = this.type;
          result.contactInformation = this.contactInformation;
                      return result;
    }

    public com.engagehub.api.codegen.types.Business.Builder id(String id) {
      this.id = id;
      return this;
    }

    public com.engagehub.api.codegen.types.Business.Builder name(String name) {
      this.name = name;
      return this;
    }

    public com.engagehub.api.codegen.types.Business.Builder address(String address) {
      this.address = address;
      return this;
    }

    public com.engagehub.api.codegen.types.Business.Builder type(String type) {
      this.type = type;
      return this;
    }

    public com.engagehub.api.codegen.types.Business.Builder contactInformation(
        String contactInformation) {
      this.contactInformation = contactInformation;
      return this;
    }
  }
}
