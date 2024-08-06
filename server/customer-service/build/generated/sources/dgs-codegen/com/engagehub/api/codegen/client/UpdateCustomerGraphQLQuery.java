package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class UpdateCustomerGraphQLQuery extends GraphQLQuery {
  public UpdateCustomerGraphQLQuery(String id, String name, String email, String phoneNumber,
      String queryName, Set<String> fieldsSet) {
    super("mutation", queryName);
    if (id != null || fieldsSet.contains("id")) {
        getInput().put("id", id);
    }if (name != null || fieldsSet.contains("name")) {
        getInput().put("name", name);
    }if (email != null || fieldsSet.contains("email")) {
        getInput().put("email", email);
    }if (phoneNumber != null || fieldsSet.contains("phoneNumber")) {
        getInput().put("phoneNumber", phoneNumber);
    }
  }

  public UpdateCustomerGraphQLQuery() {
    super("mutation");
  }

  @Override
  public String getOperationName() {
     return "updateCustomer";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private String id;

    private String name;

    private String email;

    private String phoneNumber;

    private String queryName;

    public UpdateCustomerGraphQLQuery build() {
      return new UpdateCustomerGraphQLQuery(id, name, email, phoneNumber, queryName, fieldsSet);
               
    }

    public Builder id(String id) {
      this.id = id;
      this.fieldsSet.add("id");
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      this.fieldsSet.add("name");
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      this.fieldsSet.add("email");
      return this;
    }

    public Builder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      this.fieldsSet.add("phoneNumber");
      return this;
    }

    public Builder queryName(String queryName) {
      this.queryName = queryName;
      return this;
    }
  }
}
