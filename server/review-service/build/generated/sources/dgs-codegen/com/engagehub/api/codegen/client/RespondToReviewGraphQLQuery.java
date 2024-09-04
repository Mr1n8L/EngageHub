package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class RespondToReviewGraphQLQuery extends GraphQLQuery {
  public RespondToReviewGraphQLQuery(String reviewId, String response, String queryName,
      Set<String> fieldsSet) {
    super("mutation", queryName);
    if (reviewId != null || fieldsSet.contains("reviewId")) {
        getInput().put("reviewId", reviewId);
    }if (response != null || fieldsSet.contains("response")) {
        getInput().put("response", response);
    }
  }

  public RespondToReviewGraphQLQuery() {
    super("mutation");
  }

  @Override
  public String getOperationName() {
     return "respondToReview";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private String reviewId;

    private String response;

    private String queryName;

    public RespondToReviewGraphQLQuery build() {
      return new RespondToReviewGraphQLQuery(reviewId, response, queryName, fieldsSet);
               
    }

    public Builder reviewId(String reviewId) {
      this.reviewId = reviewId;
      this.fieldsSet.add("reviewId");
      return this;
    }

    public Builder response(String response) {
      this.response = response;
      this.fieldsSet.add("response");
      return this;
    }

    public Builder queryName(String queryName) {
      this.queryName = queryName;
      return this;
    }
  }
}
