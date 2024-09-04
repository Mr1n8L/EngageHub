package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class ReviewsGraphQLQuery extends GraphQLQuery {
  public ReviewsGraphQLQuery(String queryName) {
    super("query", queryName);
  }

  public ReviewsGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "reviews";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private String queryName;

    public ReviewsGraphQLQuery build() {
      return new ReviewsGraphQLQuery(queryName);                                     
    }

    public Builder queryName(String queryName) {
      this.queryName = queryName;
      return this;
    }
  }
}
