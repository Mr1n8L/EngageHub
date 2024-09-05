package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class BusinessesGraphQLQuery extends GraphQLQuery {
  public BusinessesGraphQLQuery(String queryName) {
    super("query", queryName);
  }

  public BusinessesGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "businesses";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private String queryName;

    public BusinessesGraphQLQuery build() {
      return new BusinessesGraphQLQuery(queryName);                                     
    }

    public Builder queryName(String queryName) {
      this.queryName = queryName;
      return this;
    }
  }
}
