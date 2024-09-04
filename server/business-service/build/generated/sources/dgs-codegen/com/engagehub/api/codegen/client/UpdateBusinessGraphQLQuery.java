package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class UpdateBusinessGraphQLQuery extends GraphQLQuery {
  public UpdateBusinessGraphQLQuery(String id, String name, String address, String type,
      String contactInformation, String queryName, Set<String> fieldsSet) {
    super("mutation", queryName);
    if (id != null || fieldsSet.contains("id")) {
        getInput().put("id", id);
    }if (name != null || fieldsSet.contains("name")) {
        getInput().put("name", name);
    }if (address != null || fieldsSet.contains("address")) {
        getInput().put("address", address);
    }if (type != null || fieldsSet.contains("type")) {
        getInput().put("type", type);
    }if (contactInformation != null || fieldsSet.contains("contactInformation")) {
        getInput().put("contactInformation", contactInformation);
    }
  }

  public UpdateBusinessGraphQLQuery() {
    super("mutation");
  }

  @Override
  public String getOperationName() {
     return "updateBusiness";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private String id;

    private String name;

    private String address;

    private String type;

    private String contactInformation;

    private String queryName;

    public UpdateBusinessGraphQLQuery build() {
      return new UpdateBusinessGraphQLQuery(id, name, address, type, contactInformation, queryName, fieldsSet);
               
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

    public Builder address(String address) {
      this.address = address;
      this.fieldsSet.add("address");
      return this;
    }

    public Builder type(String type) {
      this.type = type;
      this.fieldsSet.add("type");
      return this;
    }

    public Builder contactInformation(String contactInformation) {
      this.contactInformation = contactInformation;
      this.fieldsSet.add("contactInformation");
      return this;
    }

    public Builder queryName(String queryName) {
      this.queryName = queryName;
      return this;
    }
  }
}
