package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class CustomersGraphQLQuery extends GraphQLQuery {
  public CustomersGraphQLQuery(String queryName) {
    super("query", queryName);
  }

  public CustomersGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "customers";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private String queryName;

    public CustomersGraphQLQuery build() {
      return new CustomersGraphQLQuery(queryName);                                     
    }

    public Builder queryName(String queryName) {
      this.queryName = queryName;
      return this;
    }
  }
}
