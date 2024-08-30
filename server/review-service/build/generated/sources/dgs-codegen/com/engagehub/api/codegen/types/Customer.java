package com.engagehub.api.codegen.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Customer {
  private String id;

  private String name;

  private String email;

  private String phoneNumber;

  public Customer() {
  }

  public Customer(String id, String name, String email, String phoneNumber) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "Customer{" + "id='" + id + "'," +"name='" + name + "'," +"email='" + email + "'," +"phoneNumber='" + phoneNumber + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer that = (Customer) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(email, that.email) &&
                            java.util.Objects.equals(phoneNumber, that.phoneNumber);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, name, email, phoneNumber);
  }

  public static com.engagehub.api.codegen.types.Customer.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String name;

    private String email;

    private String phoneNumber;

    public Customer build() {
                  com.engagehub.api.codegen.types.Customer result = new com.engagehub.api.codegen.types.Customer();
                      result.id = this.id;
          result.name = this.name;
          result.email = this.email;
          result.phoneNumber = this.phoneNumber;
                      return result;
    }

    public com.engagehub.api.codegen.types.Customer.Builder id(String id) {
      this.id = id;
      return this;
    }

    public com.engagehub.api.codegen.types.Customer.Builder name(String name) {
      this.name = name;
      return this;
    }

    public com.engagehub.api.codegen.types.Customer.Builder email(String email) {
      this.email = email;
      return this;
    }

    public com.engagehub.api.codegen.types.Customer.Builder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }
  }
}
